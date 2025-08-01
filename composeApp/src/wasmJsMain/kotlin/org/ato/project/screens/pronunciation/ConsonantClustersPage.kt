package org.ato.project.screens.pronunciation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.ato.project.components.NavCategory
import org.ato.project.components.NavItem
import org.ato.project.components.NavigationTemplate

@Composable
fun ConsonantClustersPage(
    onBack: () -> Unit,
    onNavigateToLesson: (String) -> Unit = {}
) {
    // Define categories with their items for consonant clusters
    val categories = listOf(
        NavCategory(
            id = "initial", 
            name = "Начальные кластеры", 
            color = Color(0xFFE91E63),
            items = listOf(
                NavItem(
                    id = "initial-1",
                    title = "(/sp/, /st/, /sk/, /sm/)", 
                    description = "Артикуляция и практика",
                    categoryId = "initial",
                    onClick = { onNavigateToLesson("initial-1") }
                )
            )
        ),
        NavCategory(
            id = "r-clusters", 
            name = "Кластеры с /r/", 
            color = Color(0xFF9C27B0),
            items = listOf(
                NavItem(
                    id = "r-clusters-1",
                    title = "(/pr/, /tr/, /kr/, /fr/, /gr/)", 
                    description = "Практика произношения",
                    categoryId = "r-clusters",
                    onClick = { /* TODO */ }
                )
            )
        ),
        NavCategory(
            id = "l-clusters", 
            name = "Кластеры с /l/", 
            color = Color(0xFF673AB7),
            items = listOf(
                NavItem(
                    id = "l-clusters-1",
                    title = "(/pl/, /bl/, /kl/, /fl/, /gl/)", 
                    description = "Практика произношения",
                    categoryId = "l-clusters",
                    onClick = { /* TODO */ }
                )
            )
        ),
        NavCategory(
            id = "complex", 
            name = "Сложные кластеры", 
            color = Color(0xFF3F51B5),
            items = listOf(
                NavItem(
                    id = "complex-1",
                    title = "(/str/, /spr/, /spl/, /skr/)", 
                    description = "Произношение сложных сочетаний",
                    categoryId = "complex",
                    onClick = { /* TODO */ }
                ),
                NavItem(
                    id = "complex-2",
                    title = "Кластеры с /θ/, /ð/", 
                    description = "Артикуляция и практика",
                    categoryId = "complex",
                    onClick = { /* TODO */ }
                )
            )
        ),
        NavCategory(
            id = "final", 
            name = "Конечные кластеры", 
            color = Color(0xFF009688),
            items = listOf(
                NavItem(
                    id = "final-1",
                    title = "(/nd/, /st/, /ld/, /ŋk/, /nts/)", 
                    description = "Практика произношения",
                    categoryId = "final",
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
                    id = "clusters-review",
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
        title = "Сочетания согласных",
        subtitle = "Практика произношения сложных сочетаний согласных звуков",
        categories = categories,
        onBack = onBack
    )
}
