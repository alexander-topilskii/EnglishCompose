package org.ato.project.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.ato.project.components.NavCategory
import org.ato.project.components.NavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToDetails: () -> Unit,
    onNavigateToExamples: () -> Unit
) {
    val density = LocalDensity.current
    var screenWidth by remember { mutableStateOf(0.dp) }

    // Define categories with distinct colors
    val categories = listOf(
        NavCategory("demos", "Demo Pages", Color(0xFF5B8EDB)),
        NavCategory("tools", "Interactive Tools", Color(0xFF26A69A)),
        NavCategory("examples", "Examples", Color(0xFFEF6C00))
    )

    // Define navigation cards with their categories and derived colors
    val navCards = listOf(
        NavItem(
            id = "details",
            title = "Details Page", 
            description = "View a simple details page example",
            categoryId = "demos",
            onClick = onNavigateToDetails
        ),
        NavItem(
            id = "calculator",
            title = "Calculator", 
            description = "Basic arithmetic calculator",
            categoryId = "tools",
            onClick = { /* TODO */ }
        ),
        NavItem(
            id = "settings",
            title = "Settings", 
            description = "Application configuration",
            categoryId = "demos",
            onClick = { /* TODO */ }
        ),
        NavItem(
            id = "examples",
            title = "Examples Gallery", 
            description = "Browse various code examples",
            categoryId = "examples",
            onClick = onNavigateToExamples
        ),
        NavItem(
            id = "about",
            title = "About", 
            description = "Information about this application",
            categoryId = "examples",
            onClick = { /* TODO */ }
        )
    )

    // State for selected categories (multi-select)
    val selectedCategories = remember { mutableStateMapOf<String, Boolean>() }

    // Initialize with all categories selected
    LaunchedEffect(Unit) {
        categories.forEach { category -> 
            selectedCategories[category.id] = true 
        }
    }

    // Filter cards based on selected categories
    val filteredCards = if (selectedCategories.isEmpty() || selectedCategories.none { it.value }) {
        // If no categories selected, show all
        navCards
    } else {
        // Show only cards from selected categories
        navCards.filter { card -> selectedCategories[card.categoryId] == true }
    }

    // Group cards by category
    val groupedCards = filteredCards.groupBy { it.categoryId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Compose Web App") },
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .onSizeChanged { size ->
                    with(density) {
                        screenWidth = size.width.toDp()
                    }
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Determine if mobile-like layout (< 768dp ~ tablets/phones)
            val isMobile = screenWidth < 768.dp

            // App title and description
            Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Welcome to Compose Web App",
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Category filter row with colored chips
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    categories.forEach { category ->
                        val isSelected = selectedCategories[category.id] == true
                        FilterChip(
                            selected = isSelected,
                            onClick = { 
                                selectedCategories[category.id] = !isSelected 
                            },
                            label = { Text(category.name) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = category.color.copy(alpha = 0.7f),
                                selectedLabelColor = Color.White
                            )
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }

            // Cards grouped by category
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                categories.forEach { category ->
                    val categoryCards = groupedCards[category.id] ?: emptyList()

                    if (categoryCards.isNotEmpty()) {
                        item {
                            Column {
                                // Category header
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(bottom = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(16.dp)
                                            .background(category.color, RoundedCornerShape(4.dp))
                                    )
                                    Spacer(Modifier.width(8.dp))
                                    Text(
                                        text = category.name,
                                        style = MaterialTheme.typography.titleLarge,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                // Grid of cards for this category
                                LazyVerticalGrid(
                                    columns = GridCells.Fixed(if (isMobile) 1 else 3),
                                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                                    verticalArrangement = Arrangement.spacedBy(16.dp),
                                    userScrollEnabled = false,  // Prevent nested scrolling
                                    modifier = Modifier.height(
                                        if (isMobile) {
                                            (categoryCards.size * 150).dp
                                        } else {
                                            ((categoryCards.size + 2) / 3 * 150).dp
                                        }
                                    )
                                ) {
                                    items(categoryCards) { card ->
                                        NavigationCard(
                                            card = card,
                                            categoryColor = category.color
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NavigationCard(
    card: NavItem,
    categoryColor: Color
) {
    // Generate a unique shade based on the card ID
    val cardColor = remember(card.id) {
        // Create a variation of the category color
        val hashValue = card.id.hashCode()
        val lightnessAdjust = (hashValue % 30) / 100f  // -0.3 to 0.3 adjustment

        // Simple way to lighten/darken
        val factor = 1f + lightnessAdjust
        Color(
            red = (categoryColor.red * factor).coerceIn(0f, 1f),
            green = (categoryColor.green * factor).coerceIn(0f, 1f),
            blue = (categoryColor.blue * factor).coerceIn(0f, 1f),
            alpha = categoryColor.alpha
        )
    }

    // Determine text color based on background brightness
    val textColor = if ((cardColor.red * 0.299 + cardColor.green * 0.587 + cardColor.blue * 0.114) > 0.5) {
        Color.Black
    } else {
        Color.White
    }

    Card(
        onClick = card.onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = card.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = textColor
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = card.description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = textColor.copy(alpha = 0.8f),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}