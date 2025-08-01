package org.ato.project.screens.pronunciation.lessons

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.ato.project.components.AdaptiveScreen

/**
 * Базовый экран для уроков произношения
 */
@Composable
fun BaseLessonScreen(
    title: String,
    subtitle: String = "",
    onBack: () -> Unit
) {
    AdaptiveScreen(
        title = title,
        onBack = onBack,
        footerText = "© 2025 English Pronunciation Practice"
    ) { isVerticalLayout, screenWidth ->
        Column(
            modifier = Modifier
                .fillMaxWidth(if (isVerticalLayout) 1f else 0.8f)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (subtitle.isNotEmpty()) {
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }

            Text(
                text = "Страница находится в разработке",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 32.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Скоро здесь появятся интерактивные упражнения для практики произношения",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(onClick = onBack) {
                        Text("Вернуться к списку уроков")
                    }
                }
            }
        }
    }
}
