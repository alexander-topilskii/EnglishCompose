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
                    id = "i-sound",
                    title = "/ɪ/ — Практика минимальных пар", 
                    description = "ship/sheep, bit/beat",
                    categoryId = "short-vowels",
                    onClick = { onNavigateToLesson("i-sound") }
                ),
                NavItem(
                    id = "ae-sound",
                    title = "/æ/ — Практика минимальных пар", 
                    description = "cat/cut, bad/bed",
                    categoryId = "short-vowels",
                    onClick = { onNavigateToLesson("ae-sound") }
                ),
                NavItem(
                    id = "e-sound",
                    title = "/e/ — Практика минимальных пар", 
                    description = "bed/bad, pen/pin",
                    categoryId = "short-vowels",
                    onClick = { onNavigateToLesson("e-sound") }
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
                ),
                NavItem(
                    id = "i-long-sound",
                    title = "/i:/ — Практика минимальных пар", 
                    description = "sheep/ship, beat/bit",
                    categoryId = "long-vowels",
                    onClick = { onNavigateToLesson("i-long-sound") }
                ),
                NavItem(
                    id = "u-long-sound",
                    title = "/u:/ — Практика минимальных пар", 
                    description = "pool/pull, food/foot",
                    categoryId = "long-vowels",
                    onClick = { onNavigateToLesson("u-long-sound") }
                ),
                NavItem(
                    id = "er-long-sound",
                    title = "/ɜ:/ — Практика минимальных пар", 
                    description = "bird/bad, fur/far",
                    categoryId = "long-vowels",
                    onClick = { onNavigateToLesson("er-long-sound") }
                )
            )
        ),
        NavCategory(
            id = "other-vowels", 
            name = "Другие гласные", 
            color = Color(0xFF3F51B5),
            items = listOf(
                NavItem(
                    id = "other-vowels-1",
                    title = "Другие гласные (/ʌ/, /ɒ/, /ɔ:/, /ɑ:/)", 
                    description = "Сравнение и практика",
                    categoryId = "other-vowels",
                    onClick = { onNavigateToLesson("other-vowels-1") }
                ),
                NavItem(
                    id = "uh-sound",
                    title = "/ʌ/ — Практика", 
                    description = "cut/cat, luck/lack",
                    categoryId = "other-vowels",
                    onClick = { onNavigateToLesson("uh-sound") }
                ),
                NavItem(
                    id = "o-short-sound",
                    title = "/ɒ/ — Практика", 
                    description = "hot/hat, pot/pet",
                    categoryId = "other-vowels",
                    onClick = { onNavigateToLesson("o-short-sound") }
                ),
                NavItem(
                    id = "o-long-sound",
                    title = "/ɔ:/ — Практика", 
                    description = "thought/taught, law/low",
                    categoryId = "other-vowels",
                    onClick = { onNavigateToLesson("o-long-sound") }
                ),
                NavItem(
                    id = "a-long-sound",
                    title = "/ɑ:/ — Практика", 
                    description = "car/cat, father/further",
                    categoryId = "other-vowels",
                    onClick = { onNavigateToLesson("a-long-sound") }
                )
            )
        ),
        NavCategory(
            id = "schwa", 
            name = "Нейтральный гласный", 
            color = Color(0xFF26A69A),
            items = listOf(
                NavItem(
                    id = "schwa-sound",
                    title = "Шва (/ə/) и его роль в безударных слогах", 
                    description = "Практика редукции",
                    categoryId = "schwa",
                    onClick = { onNavigateToLesson("schwa-sound") }
                )
            )
        )
    )

    // Use the NavigationTemplate component with back button
    NavigationTemplate(
        title = "Гласные звуки и их перекрестное сравнение",
        subtitle = "Выберите категорию гласных звуков для изучения",
        categories = categories,
        onBack = onBack
    )
}
