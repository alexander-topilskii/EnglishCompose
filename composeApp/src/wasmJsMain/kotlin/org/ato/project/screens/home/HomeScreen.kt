package org.ato.project.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.ato.project.components.NavCategory
import org.ato.project.components.NavItem
import org.ato.project.components.NavigationTemplate

@Composable
fun HomeScreen(
    onNavigateToDetails: () -> Unit,
    onNavigateToExamples: () -> Unit,
    onNavigateToVerbs: () -> Unit = { /* Fallback */ },
    onNavigateToAdjectives: () -> Unit = { /* Fallback */ },
    onNavigateToNouns: () -> Unit = { /* Fallback */ }
) {
    // Define categories with their items
    val categories = listOf(
        NavCategory(
            id = "words", 
            name = "Слова", 
            color = Color(0xFF5B8EDB),
            items = listOf(
                NavItem(
                    id = "verbs",
                    title = "Глаголы", 
                    description = "Изучение английских глаголов",
                    categoryId = "words",
                    onClick = onNavigateToVerbs
                ),
                NavItem(
                    id = "adjectives",
                    title = "Прилагательные", 
                    description = "Изучение английских прилагательных",
                    categoryId = "words",
                    onClick = onNavigateToAdjectives
                ),
                NavItem(
                    id = "nouns",
                    title = "Существительные", 
                    description = "Изучение английских существительных",
                    categoryId = "words",
                    onClick = onNavigateToNouns
                )
            )
        ),
        NavCategory(
            id = "pronunciation", 
            name = "Произношение", 
            color = Color(0xFF26A69A),
            items = listOf(
                NavItem(
                    id = "vowels",
                    title = "Гласные звуки", 
                    description = "Гласные звуки и их перекрестное сравнение",
                    categoryId = "pronunciation",
                    onClick = onNavigateToExamples
                ),
                NavItem(
                    id = "consonants",
                    title = "Согласные звуки", 
                    description = "Артикуляция и практика согласных звуков",
                    categoryId = "pronunciation",
                    onClick = { onNavigateToExamples() }
                ),
                NavItem(
                    id = "consonant-clusters",
                    title = "Сочетания согласных", 
                    description = "Практика произношения сложных сочетаний",
                    categoryId = "pronunciation",
                    onClick = { onNavigateToExamples() }
                ),
                NavItem(
                    id = "word-stress",
                    title = "Ударение в словах", 
                    description = "Правила и практика ударений",
                    categoryId = "pronunciation",
                    onClick = { onNavigateToExamples() }
                )
            )
        ),
        NavCategory(
            id = "idioms", 
            name = "Фразеологизмы", 
            color = Color(0xFFEF6C00),
            items = listOf(
                NavItem(
                    id = "idioms-gallery",
                    title = "Галерея фразеологизмов", 
                    description = "Изучение английских идиом и выражений",
                    categoryId = "idioms",
                    onClick = onNavigateToDetails
                )
            )
        )
    )

    // Use the NavigationTemplate component
    NavigationTemplate(
        title = "English Learning App",
        subtitle = "Выберите раздел для изучения",
        categories = categories
    )
}
