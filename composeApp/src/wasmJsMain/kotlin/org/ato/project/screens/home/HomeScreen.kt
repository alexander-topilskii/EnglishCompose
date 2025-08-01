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
    // Define categories with their items
    val categories = listOf(
        NavCategory(
            id = "demos", 
            name = "Demo Pages", 
            color = Color(0xFF5B8EDB),
            items = listOf(
                NavItem(
                    id = "details",
                    title = "Details Page", 
                    description = "View a simple details page example",
                    categoryId = "demos",
                    onClick = onNavigateToDetails
                ),
                NavItem(
                    id = "settings",
                    title = "Settings", 
                    description = "Application configuration",
                    categoryId = "demos",
                    onClick = { /* TODO */ }
                )
            )
        ),
        NavCategory(
            id = "tools", 
            name = "Interactive Tools", 
            color = Color(0xFF26A69A),
            items = listOf(
                NavItem(
                    id = "calculator",
                    title = "Calculator", 
                    description = "Basic arithmetic calculator",
                    categoryId = "tools",
                    onClick = { /* TODO */ }
                )
            )
        ),
        NavCategory(
            id = "examples", 
            name = "Examples", 
            color = Color(0xFFEF6C00),
            items = listOf(
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
        )
    )

    // Use the NavigationTemplate component
    NavigationTemplate(
        title = "Compose Web App 2.0 github",
        categories = categories
    )
}
