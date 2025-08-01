package org.ato.project.screens.pronunciation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.ato.project.components.NavCategory
import org.ato.project.components.NavItem
import org.ato.project.components.NavigationTemplate

@Composable
fun DiphthongsPage(
    onBack: () -> Unit,
    onNavigateToLesson: (String) -> Unit = {}
) {
    // Define categories with their items for diphthongs
    val categories = listOf(
        NavCategory(
            id = "centering-diphthongs", 
            name = "Центрирующие дифтонги", 
            color = Color(0xFF7E57C2),
            items = listOf(
                NavItem(
                    id = "centering-diphthongs-1",
                    title = "Центрирующие дифтонги (/ɪə/, /eə/, /ʊə/)", 
                    description = "Практика произношения",
                    categoryId = "centering-diphthongs",
                    onClick = { onNavigateToLesson("centering-diphthongs-1") }
                ),
                NavItem(
                    id = "ir-diphthong",
                    title = "/ɪə/ — Примеры", 
                    description = "near, beer, fear",
                    categoryId = "centering-diphthongs",
                    onClick = { onNavigateToLesson("ir-diphthong") }
                ),
                NavItem(
                    id = "er-diphthong",
                    title = "/eə/ — Примеры", 
                    description = "hair, care, there",
                    categoryId = "centering-diphthongs",
                    onClick = { onNavigateToLesson("er-diphthong") }
                ),
                NavItem(
                    id = "ur-diphthong",
                    title = "/ʊə/ — Примеры", 
                    description = "tour, poor, sure",
                    categoryId = "centering-diphthongs",
                    onClick = { onNavigateToLesson("ur-diphthong") }
                )
            )
        ),
        NavCategory(
            id = "closing-diphthongs", 
            name = "Закрывающие дифтонги", 
            color = Color(0xFF26A69A),
            items = listOf(
                NavItem(
                    id = "closing-diphthongs-1",
                    title = "Закрывающие дифтонги (/eɪ/, /aɪ/, /ɔɪ/, /əʊ/, /aʊ/)", 
                    description = "Практика минимальных пар",
                    categoryId = "closing-diphthongs",
                    onClick = { onNavigateToLesson("closing-diphthongs-1") }
                ),
                NavItem(
                    id = "ei-diphthong",
                    title = "/eɪ/ — Практика", 
                    description = "day, face, rain",
                    categoryId = "closing-diphthongs",
                    onClick = { onNavigateToLesson("ei-diphthong") }
                ),
                NavItem(
                    id = "ai-diphthong",
                    title = "/aɪ/ — Практика", 
                    description = "time, high, my",
                    categoryId = "closing-diphthongs",
                    onClick = { onNavigateToLesson("ai-diphthong") }
                ),
                NavItem(
                    id = "oi-diphthong",
                    title = "/ɔɪ/ — Практика", 
                    description = "boy, coin, noise",
                    categoryId = "closing-diphthongs",
                    onClick = { onNavigateToLesson("oi-diphthong") }
                ),
                NavItem(
                    id = "ou-diphthong",
                    title = "/əʊ/ — Практика", 
                    description = "go, home, no",
                    categoryId = "closing-diphthongs",
                    onClick = { onNavigateToLesson("ou-diphthong") }
                ),
                NavItem(
                    id = "au-diphthong",
                    title = "/aʊ/ — Практика", 
                    description = "now, out, house",
                    categoryId = "closing-diphthongs",
                    onClick = { onNavigateToLesson("au-diphthong") }
                )
            )
        )
    )

    // Use the NavigationTemplate component with back button
    NavigationTemplate(
        title = "Дифтонги и их произношение",
        subtitle = "Выберите категорию дифтонгов для изучения",
        categories = categories,
        onBack = onBack
    )
}
