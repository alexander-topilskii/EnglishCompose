package org.ato.project.screens.idioms

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.ato.project.components.AdaptiveScreen

@Composable
fun IdiomsPage(onBack: () -> Unit) {
    AdaptiveScreen(
        title = "Фразеологизмы",
        onBack = onBack,
        footerText = "© 2025 English Idioms Collection"
    ) { isVerticalLayout, _ ->
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Раздел находится в разработке",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Скоро здесь появится коллекция английских фразеологизмов и идиом с примерами использования",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = onBack) {
                Text("Вернуться на главную")
            }
        }
    }
}
