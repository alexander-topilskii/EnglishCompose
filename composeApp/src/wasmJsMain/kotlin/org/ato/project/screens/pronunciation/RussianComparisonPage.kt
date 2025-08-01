package org.ato.project.screens.pronunciation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.ato.project.components.NavCategory
import org.ato.project.components.NavItem
import org.ato.project.components.NavigationTemplate

@Composable
fun RussianComparisonPage(
    onBack: () -> Unit,
    onNavigateToLesson: (String) -> Unit = {}
) {
    // Define categories with their items for Russian comparison
    val categories = listOf(
        NavCategory(
            id = "missing-sounds", 
            name = "Отсутствующие звуки", 
            color = Color(0xFFE57373),
            items = listOf(
                NavItem(
                    id = "missing-sounds-1",
                    title = "Звуки, отсутствующие в русском", 
                    description = "/θ/, /ð/, /ŋ/, /h/",
                    categoryId = "missing-sounds",
                    onClick = { onNavigateToLesson("missing-sounds-1") }
                )
            )
        ),
        NavCategory(
            id = "vowel-issues", 
            name = "Проблемы с гласными", 
            color = Color(0xFF81C784),
            items = listOf(
                NavItem(
                    id = "vowel-issues-1",
                    title = "Проблемы с гласными", 
                    description = "Длина, качество",
                    categoryId = "vowel-issues",
                    onClick = { onNavigateToLesson("vowel-issues-1") }
                )
            )
        ),
        NavCategory(
            id = "correction", 
            name = "Коррекция", 
            color = Color(0xFF4FC3F7),
            items = listOf(
                NavItem(
                    id = "correction-1",
                    title = "Упражнения на коррекцию типичных ошибок", 
                    description = "Для русскоязычных",
                    categoryId = "correction",
                    onClick = { onNavigateToLesson("correction-1") }
                )
            )
        )
    )

    // Use the NavigationTemplate component with back button
    NavigationTemplate(
        title = "Сравнение с русским произношением",
        subtitle = "Типичные ошибки и способы их исправления",
        categories = categories,
        onBack = onBack
    )
}
