package org.ato.project.screens.pronunciation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun VoicelessConsonantsLessonScreen(onBack: () -> Unit) {
    PronunciationLessonScreen(
        title = "Глухие согласные",
        subtitle = "Глухие согласные звуки /θ/, /ʃ/, /tʃ/, /h/",
        description = "Артикуляция и практика минимальных пар для глухих согласных английского языка",
        onBack = onBack
    ) {
        // Sound cards section
        Text(
            text = "Звуки",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            SoundCard(
                symbol = "/θ/",
                examples = listOf("think", "three", "mouth"),
                description = "Кончик языка между зубами, выдыхаемый воздух",
                color = Color(0xFFE57373)
            )

            SoundCard(
                symbol = "/ʃ/",
                examples = listOf("ship", "fish", "show"),
                description = "Губы округлены, язык отведен назад",
                color = Color(0xFF81C784)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            SoundCard(
                symbol = "/tʃ/",
                examples = listOf("chair", "match", "church"),
                description = "Аффриката: смычка + щелевой согласный",
                color = Color(0xFF64B5F6)
            )

            SoundCard(
                symbol = "/h/",
                examples = listOf("house", "hello", "who"),
                description = "Выдох с голосом последующего гласного",
                color = Color(0xFFFFB74D)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Minimal pairs section
        Text(
            text = "Минимальные пары",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MinimalPairRow("think", "sink", "/θ/", "/s/")
            MinimalPairRow("thin", "fin", "/θ/", "/f/")
            MinimalPairRow("ship", "sip", "/ʃ/", "/s/")
            MinimalPairRow("wash", "watch", "/ʃ/", "/tʃ/")
            MinimalPairRow("chair", "share", "/tʃ/", "/ʃ/")
            MinimalPairRow("heat", "eat", "/h/", "/-/")
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Articulation section
        Text(
            text = "Артикуляция",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(0.8f),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Советы по произношению /θ/",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "1. Слегка высуньте кончик языка между зубами\n" +
                          "2. Дуйте воздух через щель между языком и верхними зубами\n" +
                          "3. Не используйте голос (звук должен быть глухим)\n" +
                          "4. Избегайте замены на звуки /s/ или /f/",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Practice section
        Text(
            text = "Упражнения для практики",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        PracticeExercise(
            title = "Скороговорка с /θ/",
            instructions = "Повторяйте, постепенно увеличивая скорость:",
            words = listOf("Three thin thinkers thinking thick thoughtful thoughts")
        )

        Spacer(modifier = Modifier.height(16.dp))

        PracticeExercise(
            title = "Скороговорка с /ʃ/",
            instructions = "Повторяйте, постепенно увеличивая скорость:",
            words = listOf("She sells seashells by the seashore")
        )
    }
}
