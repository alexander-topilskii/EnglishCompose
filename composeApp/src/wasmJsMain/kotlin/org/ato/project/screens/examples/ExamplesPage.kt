package org.ato.project.screens.examples

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.ato.project.components.NavCategory
import org.ato.project.components.NavItem
import org.ato.project.components.NavigationTemplate

@Composable
fun ExamplesPage(onBack: () -> Unit) {
    // Define sub-categories for examples
    val categories = listOf(
        NavCategory("basic", "Basic Examples", Color(0xFFEC407A)),
        NavCategory("advanced", "Advanced Examples", Color(0xFF7E57C2)),
        NavCategory("layouts", "Layout Examples", Color(0xFF26A69A))
    )

    // Define navigation items for the examples page
    val navItems = listOf(
        NavItem(
            id = "counter",
            title = "Counter Example", 
            description = "Basic state management with a counter",
            categoryId = "basic",
            onClick = { /* TODO: Navigate to counter example */ }
        ),
        NavItem(
            id = "todo",
            title = "Todo List", 
            description = "Simple todo application",
            categoryId = "basic",
            onClick = { /* TODO: Navigate to todo list example */ }
        ),
        NavItem(
            id = "animation",
            title = "Animations", 
            description = "Examples of various animations",
            categoryId = "advanced",
            onClick = { /* TODO: Navigate to animation examples */ }
        ),
        NavItem(
            id = "gestures",
            title = "Gesture Handling", 
            description = "Examples of different gestures",
            categoryId = "advanced",
            onClick = { /* TODO: Navigate to gesture examples */ }
        ),
        NavItem(
            id = "grid",
            title = "Grid Layout", 
            description = "Example of grid layouts",
            categoryId = "layouts",
            onClick = { /* TODO: Navigate to grid layout example */ }
        ),
        NavItem(
            id = "responsive",
            title = "Responsive Design", 
            description = "Examples of responsive layouts",
            categoryId = "layouts",
            onClick = { /* TODO: Navigate to responsive design examples */ }
        )
    )

    // Use the NavigationTemplate component with back button
    NavigationTemplate(
        title = "Examples Gallery",
        categories = categories,
        items = navItems,
        onBack = onBack
    )
}
