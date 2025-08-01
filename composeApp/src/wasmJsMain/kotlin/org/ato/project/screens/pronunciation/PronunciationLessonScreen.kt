package org.ato.project.screens.pronunciation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.ato.project.components.AdaptiveScreen

/**
 * A base screen for pronunciation lessons with standardized layout
 */
@Composable
fun PronunciationLessonScreen(
    title: String,
    subtitle: String,
    description: String,
    onBack: () -> Unit,
    content: @Composable () -> Unit
) {
    AdaptiveScreen(
        title = title,
        onBack = onBack,
        footerText = "© 2025 English Pronunciation Practice"
    ) { isVerticalLayout, screenWidth ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header section
            Text(
                text = subtitle,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Divider(modifier = Modifier.padding(vertical = 16.dp))

            // Main content
            content()
        }
    }
}
