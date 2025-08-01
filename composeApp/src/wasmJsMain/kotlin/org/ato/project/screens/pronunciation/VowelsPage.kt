package org.ato.project.screens.pronunciation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.ato.project.components.NavCategory
import org.ato.project.components.NavItem
import org.ato.project.components.NavigationTemplate

@Composable
fun VowelsPage(
    onBack: () -> Unit,
    onNavigateToLesson: (String) -> Unit = {}
) {
    // Define categories with their items for vowel pronunciation
    val categories = listOf(
        NavCategory(
            id = "short-vowels", 
            name = "Короткие гласные", 
            color = Color(0xFFEC407A),
            items = listOf(
                NavItem(
                    id = "short-vowels-1",
                    title = "Короткие гласные (/ɪ/, /æ/, /e/)", 
                    description = "Практика минимальных пар",
                    categoryId = "short-vowels",
                    onClick = { onNavigateToLesson("short-vowels-1") }
                ),
                NavItem(
                    id = "short-vowels-2",
                    title = "Короткие гласные (/ʊ/, /ə/)", 
                    description = "Произношение и различение",
                    categoryId = "short-vowels",
                    onClick = { onNavigateToLesson("short-vowels-2") }
                )
            )
        ),
        NavCategory(
            id = "long-vowels", 
            name = "Длинные гласные", 
            color = Color(0xFF7E57C2),
            items = listOf(
                NavItem(
                    id = "long-vowels-1",
                    title = "Длинные гласные (/i:/, /u:/, /ɜ:/)", 
                    description = "Практика произношения",
                    categoryId = "long-vowels",
                    onClick = { onNavigateToLesson("long-vowels-1") }
                )
            )
        ),
        NavCategory(
            id = "cross-practice", 
            name = "Перекрестная практика", 
            color = Color(0xFF3F51B5),
            items = listOf(
                NavItem(
                    id = "cross-practice-1",
                    title = "(/ɪ/ vs /i:/, /æ/ vs /ɜ:/, /e/ vs /ɪ/)", 
                    description = "Минимальные пары",
                    categoryId = "cross-practice",
                    onClick = { onNavigateToLesson("cross-practice-1") }
                )
            )
        ),
        NavCategory(
            id = "diphthongs", 
            name = "Дифтонги", 
            color = Color(0xFF26A69A),
            items = listOf(
                NavItem(
                    id = "diphthongs-1",
                    title = "(/eɪ/, /aɪ/, /ɪə/)", 
                    description = "Произношение и минимальные пары",
                    categoryId = "diphthongs",
                    onClick = { onNavigateToLesson("diphthongs-1") }
                ),
                NavItem(
                    id = "diphthongs-2",
                    title = "(/oʊ/, /aʊ/, /ɔɪ/, /eə/)", 
                    description = "Практика произношения",
                    categoryId = "diphthongs",
                    onClick = { onNavigateToLesson("diphthongs-2") }
                ),
                NavItem(
                    id = "diphthongs-3",
                    title = "Дополнительные дифтонги (/ʊə/)", 
                    description = "Произношение и различение",
                    categoryId = "diphthongs",
                    onClick = { onNavigateToLesson("diphthongs-3") }
                )
            )
        ),
        NavCategory(
            id = "review", 
            name = "Повторение", 
            color = Color(0xFFEF6C00),
            items = listOf(
                NavItem(
                    id = "vowels-review",
                    title = "Повторение и аудиоанализ", 
                    description = "Закрепление изученного материала",
                    categoryId = "review",
                    onClick = { onNavigateToLesson("vowels-review") }
                )
            )
        )
    )

    // Use the NavigationTemplate component with back button
    NavigationTemplate(
        title = "Гласные звуки",
        categories = categories,
        onBack = onBack
    )
}
