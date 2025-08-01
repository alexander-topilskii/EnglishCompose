package org.ato.project.screens.pronunciation

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
fun ConsonantClustersLessonScreen(onBack: () -> Unit) {
    PronunciationLessonScreen(
        title = "Начальные кластеры",
        subtitle = "Начальные кластеры /sp/, /st/, /sk/, /sm/",
        description = "Артикуляция и практика начальных сочетаний согласных звуков",
        onBack = onBack
    ) {
        // Cluster cards section
        Text(
            text = "Кластеры",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            ClusterCard(
                cluster = "/sp/",
                examples = listOf("speak", "spoon", "sport"),
                color = Color(0xFFE57373)
            )

            ClusterCard(
                cluster = "/st/",
                examples = listOf("stop", "stay", "store"),
                color = Color(0xFF81C784)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            ClusterCard(
                cluster = "/sk/",
                examples = listOf("school", "skip", "skin"),
                color = Color(0xFF64B5F6)
            )

            ClusterCard(
                cluster = "/sm/",
                examples = listOf("small", "smile", "smart"),
                color = Color(0xFFFFB74D)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Common errors section
        Text(
            text = "Типичные ошибки",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(0.8f),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFCE4EC))
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Добавление гласного звука перед кластером",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Распространенная ошибка - добавление короткого гласного звука перед кластером:\n" +
                          "❌ [эспик] вместо ✓ [спик]\n" +
                          "❌ [эстоп] вместо ✓ [стоп]\n" +
                          "❌ [эскул] вместо ✓ [скул]",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Practice section
        Text(
            text = "Упражнения для практики",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        ClusterExercise(
            title = "Практика кластера /sp/",
            instructions = "Повторяйте слова, следя за правильным произношением кластера:",
            words = listOf("speak", "spell", "spoon", "sport", "spin", "space", "special", "spider")
        )

        Spacer(modifier = Modifier.height(16.dp))

        ClusterExercise(
            title = "Практика кластера /st/",
            instructions = "Повторяйте слова, следя за правильным произношением кластера:",
            words = listOf("stay", "stop", "stand", "start", "study", "star", "store", "student")
        )

        Spacer(modifier = Modifier.height(16.dp))

        ClusterExercise(
            title = "Практика в предложениях",
            instructions = "Произнесите эти предложения, обращая внимание на кластеры:",
            sentences = listOf(
                "Steve spoke to the students about space.",
                "Stella stayed at school to study statistics.",
                "Skilled specialists spend time solving specific problems."
            )
        )
    }
}

@Composable
fun ClusterCard(
    cluster: String,
    examples: List<String>,
    color: Color
) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(160.dp),
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
                text = cluster,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = examples.joinToString("\n"),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ClusterExercise(
    title: String,
    instructions: String,
    words: List<String> = emptyList(),
    sentences: List<String> = emptyList()
) {
    Card(
        modifier = Modifier.fillMaxWidth(0.8f),
        shape = RoundedCornerShape(8.dp),
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = words.joinToString("  •  "),
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center
                    )
                }
            }

            if (sentences.isNotEmpty()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    sentences.forEach { sentence ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White)
                        ) {
                            Text(
                                text = sentence,
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.padding(12.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}
