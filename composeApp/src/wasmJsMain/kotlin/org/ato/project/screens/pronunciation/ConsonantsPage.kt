package org.ato.project.screens.pronunciation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.ato.project.components.NavCategory
import org.ato.project.components.NavItem
import org.ato.project.components.NavigationTemplate

@Composable
fun ConsonantsPage(
    onBack: () -> Unit,
    onNavigateToLesson: (String) -> Unit = {}
) {
    // Define categories with their items for consonant pronunciation
    val categories = listOf(
        NavCategory(
            id = "voiceless", 
            name = "Глухие согласные", 
            color = Color(0xFFE91E63),
            items = listOf(
                NavItem(
                    id = "voiceless-1",
                    title = "(/θ/, /ʃ/, /tʃ/, /h/)", 
                    description = "Артикуляция и минимальные пары",
                    categoryId = "voiceless",
                    onClick = { onNavigateToLesson("voiceless-1") }
                )
            )
        ),
        NavCategory(
            id = "voiced", 
            name = "Звонкие согласные", 
            color = Color(0xFF9C27B0),
            items = listOf(
                NavItem(
                    id = "voiced-1",
                    title = "(/ð/, /ʒ/, /dʒ/)", 
                    description = "Произношение и минимальные пары",
                    categoryId = "voiced",
                    onClick = { /* TODO */ }
                )
            )
        ),
        NavCategory(
            id = "paired-1", 
            name = "Парные согласные 1", 
            color = Color(0xFF673AB7),
            items = listOf(
                NavItem(
                    id = "paired-1-practice",
                    title = "(/f/-/v/, /s/-/z/)", 
                    description = "Минимальные пары и избегание девойсинга",
                    categoryId = "paired-1",
                    onClick = { /* TODO */ }
                )
            )
        ),
        NavCategory(
            id = "paired-2", 
            name = "Парные согласные 2", 
            color = Color(0xFF3F51B5),
            items = listOf(
                NavItem(
                    id = "paired-2-practice",
                    title = "(/p/-/b/, /t/-/d/, /k/-/g/)", 
                    description = "Артикуляция и практика пар",
                    categoryId = "paired-2",
                    onClick = { /* TODO */ }
                )
            )
        ),
        NavCategory(
            id = "special", 
            name = "Особые согласные", 
            color = Color(0xFF009688),
            items = listOf(
                NavItem(
                    id = "special-1",
                    title = "(/w/, /v/, /r/, /l/, /ŋ/)", 
                    description = "Произношение и минимальные пары",
                    categoryId = "special",
                    onClick = { /* TODO */ }
                ),
                NavItem(
                    id = "special-2",
                    title = "(/j/, /v/-/w/, /l/ в кластерах)", 
                    description = "Артикуляционная практика",
                    categoryId = "special",
                    onClick = { /* TODO */ }
                )
            )
        ),
        NavCategory(
            id = "review", 
            name = "Повторение", 
            color = Color(0xFFFF9800),
            items = listOf(
                NavItem(
                    id = "consonants-review",
                    title = "Повторение и аудиоанализ", 
                    description = "Закрепление изученного материала",
                    categoryId = "review",
                    onClick = { /* TODO */ }
                )
            )
        )
    )

    // Use the NavigationTemplate component with back button
    NavigationTemplate(
        title = "Согласные звуки",
        subtitle = "Артикуляция и практика согласных звуков английского языка",
        categories = categories,
        onBack = onBack
    )
}
