package org.ato.project.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.ato.project.components.NavCategory
import org.ato.project.components.NavItem
import org.ato.project.components.NavigationTemplate

@Composable
fun HomeScreen(
    onNavigateToDetails: () -> Unit,
    onNavigateToExamples: () -> Unit
) {
    // Define categories with distinct colors
    val categories = listOf(
        NavCategory("demos", "Demo Pages", Color(0xFF5B8EDB)),
        NavCategory("tools", "Interactive Tools", Color(0xFF26A69A)),
        NavCategory("examples", "Examples", Color(0xFFEF6C00))
    )

    // Define navigation items with their categories
    val items = listOf(
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

    // Use the NavigationTemplate component
    NavigationTemplate(
        title = "Compose Web App 2.0 github",
        categories = categories,
        items = items
    )
}
