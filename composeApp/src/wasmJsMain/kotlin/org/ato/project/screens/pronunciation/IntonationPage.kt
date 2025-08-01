package org.ato.project.screens.pronunciation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.ato.project.components.NavCategory
import org.ato.project.components.NavItem
import org.ato.project.components.NavigationTemplate

@Composable
fun IntonationPage(
    onBack: () -> Unit,
    onNavigateToLesson: (String) -> Unit = {}
) {
    // Define categories with their items for intonation
    val categories = listOf(
        NavCategory(
            id = "intonation-patterns", 
            name = "Интонационные модели", 
            color = Color(0xFF5C6BC0),
            items = listOf(
                NavItem(
                    id = "rising-falling",
                    title = "Восходящая и нисходящая интонация", 
                    description = "Вопросы и утверждения",
                    categoryId = "intonation-patterns",
                    onClick = { onNavigateToLesson("rising-falling") }
                )
            )
        ),
        NavCategory(
            id = "connected-speech", 
            name = "Связная речь", 
            color = Color(0xFF26A69A),
            items = listOf(
                NavItem(
                    id = "linking-sounds",
                    title = "Связывание звуков", 
                    description = "linking, assimilation, elision",
                    categoryId = "connected-speech",
                    onClick = { onNavigateToLesson("linking-sounds") }
                )
            )
        ),
        NavCategory(
            id = "practice", 
            name = "Практика", 
            color = Color(0xFFEF6C00),
            items = listOf(
                NavItem(
                    id = "tongue-twisters",
                    title = "Практика на скороговорках и диалогах", 
                    description = "Развитие беглости речи",
                    categoryId = "practice",
                    onClick = { onNavigateToLesson("tongue-twisters") }
                )
            )
        )
    )

    // Use the NavigationTemplate component with back button
    NavigationTemplate(
        title = "Интонация и связная речь",
        subtitle = "Выберите аспект интонации для изучения",
        categories = categories,
        onBack = onBack
    )
}
