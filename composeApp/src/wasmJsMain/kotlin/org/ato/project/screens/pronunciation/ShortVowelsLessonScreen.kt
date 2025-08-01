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
fun ShortVowelsLessonScreen(onBack: () -> Unit) {
    PronunciationLessonScreen(
        title = "Короткие гласные",
        subtitle = "Короткие гласные звуки /ɪ/, /æ/, /e/",
        description = "Практика минимальных пар и правильного произношения коротких гласных звуков английского языка",
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
                symbol = "/ɪ/",
                examples = listOf("sit", "pin", "fish"),
                description = "Короткий звук 'и', губы слегка растянуты",
                color = Color(0xFFE57373)
            )

            SoundCard(
                symbol = "/æ/",
                examples = listOf("cat", "map", "hand"),
                description = "Звук между 'э' и 'а', рот открыт шире",
                color = Color(0xFF81C784)
            )

            SoundCard(
                symbol = "/e/",
                examples = listOf("bed", "egg", "head"),
                description = "Короткий звук 'э', губы слегка растянуты",
                color = Color(0xFF64B5F6)
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
            MinimalPairRow("sit", "seat", "/ɪ/", "/i:/")
            MinimalPairRow("ship", "sheep", "/ɪ/", "/i:/")
            MinimalPairRow("bit", "bet", "/ɪ/", "/e/")
            MinimalPairRow("pit", "pat", "/ɪ/", "/æ/")
            MinimalPairRow("bed", "bad", "/e/", "/æ/")
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Practice section
        Text(
            text = "Упражнения для практики",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        PracticeExercise(
            title = "Повторение звуков",
            instructions = "Повторите следующие слова, обращая внимание на правильное произношение гласного звука",
            words = listOf("sit", "bit", "fit", "hit", "pin", "thin", "win", "fish", "dish", "wish")
        )

        Spacer(modifier = Modifier.height(16.dp))

        PracticeExercise(
            title = "Различение звуков",
            instructions = "Произнесите эти пары слов, четко различая гласные звуки",
            wordPairs = listOf(
                "sit - seat", "bit - beat", "fit - feet", 
                "sit - set", "pin - pen", "bin - Ben",
                "bit - bat", "pin - pan", "fit - fat"
            )
        )
    }
}

@Composable
fun SoundCard(
    symbol: String,
    examples: List<String>,
    description: String,
    color: Color
) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .height(200.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.2f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = symbol,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = examples.joinToString(", "),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun MinimalPairRow(word1: String, word2: String, sound1: String, sound2: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(word1, style = MaterialTheme.typography.titleMedium)
            Text(sound1, style = MaterialTheme.typography.bodyMedium)
        }

        Text("vs", style = MaterialTheme.typography.bodyLarge)

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(word2, style = MaterialTheme.typography.titleMedium)
            Text(sound2, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun PracticeExercise(
    title: String,
    instructions: String,
    words: List<String> = emptyList(),
    wordPairs: List<String> = emptyList()
) {
    Card(
        modifier = Modifier.fillMaxWidth(0.8f),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = instructions,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (words.isNotEmpty()) {
                // Display single words
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    words.forEach { word ->
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                                .background(Color.White, RoundedCornerShape(4.dp))
                                .padding(horizontal = 12.dp, vertical = 8.dp)
                        ) {
                            Text(word)
                        }
                    }
                }
            } else if (wordPairs.isNotEmpty()) {
                // Display word pairs
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    wordPairs.forEach { pair ->
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .background(Color.White, RoundedCornerShape(4.dp))
                                .padding(horizontal = 12.dp, vertical = 8.dp)
                        ) {
                            Text(pair)
                        }
                    }
                }
            }
        }
    }
}
