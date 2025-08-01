package org.ato.project.screens.words

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.ato.project.components.AdaptiveScreen

@Composable
fun AdjectivesScreen(onBack: () -> Unit) {
    AdaptiveScreen(
        title = "Прилагательные",
        onBack = onBack,
        footerText = "© 2025 English Learning App"
    ) { isVerticalLayout, screenWidth ->
        Column(
            modifier = Modifier
                .fillMaxWidth(if (isVerticalLayout) 1f else 0.8f)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Английские прилагательные",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Text(
                text = "Эта страница содержит информацию об английских прилагательных, их формах, степенях сравнения и примерах использования",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
            ) {
                Text(
                    text = "Раздел находится в разработке",
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(32.dp)
                )
            }
        }
    }
}
