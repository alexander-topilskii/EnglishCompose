package org.ato.project.screens.pronunciation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.ato.project.components.NavCategory
import org.ato.project.components.NavItem
import org.ato.project.components.NavigationTemplate

@Composable
fun WordStressPage(
    onBack: () -> Unit,
    onNavigateToLesson: (String) -> Unit = {}
) {
    // Define categories with their items for word stress
    val categories = listOf(
        NavCategory(
            id = "basics", 
            name = "Основы ударения", 
            color = Color(0xFFE91E63),
            items = listOf(
                NavItem(
                    id = "basics-1",
                    title = "Основы word stress", 
                    description = "(REcord vs reCORD) — практика",
                    categoryId = "basics",
                    onClick = { onNavigateToLesson("basics-1") }
                )
            )
        ),
        NavCategory(
            id = "two-syllable", 
            name = "Двухсложные слова", 
            color = Color(0xFF9C27B0),
            items = listOf(
                NavItem(
                    id = "two-syllable-1",
                    title = "Ударение и schwa", 
                    description = "Практика произношения двухсложных слов",
                    categoryId = "two-syllable",
                    onClick = { /* TODO */ }
                )
            )
        ),
        NavCategory(
            id = "three-syllable", 
            name = "Трёхсложные слова", 
            color = Color(0xFF673AB7),
            items = listOf(
                NavItem(
                    id = "three-syllable-1",
                    title = "Артикуляционная практика", 
                    description = "Практика произношения трёхсложных слов",
                    categoryId = "three-syllable",
                    onClick = { /* TODO */ }
                )
            )
        ),
        NavCategory(
            id = "complex-words", 
            name = "Сложные слова", 
            color = Color(0xFF3F51B5),
            items = listOf(
                NavItem(
                    id = "complex-words-1",
                    title = "Многосложные слова", 
                    description = "(information, photography) — практика",
                    categoryId = "complex-words",
                    onClick = { /* TODO */ }
                )
            )
        )
    )

    // Use the NavigationTemplate component with back button
    NavigationTemplate(
        title = "Ударение в словах",
        subtitle = "Правила и практика ударений в английских словах",
        categories = categories,
        onBack = onBack
    )
}
