package org.ato.project.screens.pronunciation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WordStressLessonScreen(onBack: () -> Unit) {
    PronunciationLessonScreen(
        title = "Ударение в словах",
        subtitle = "Основы word stress",
        description = "Изучение правил и практика ударения в словах английского языка",
        onBack = onBack
    ) {
        // Introduction section
        Card(
            modifier = Modifier.fillMaxWidth(0.8f),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE8EAF6))
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Что такое word stress?",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Ударение в английском языке - это выделение одного слога в слове с большей силой, высотой тона и длительностью по сравнению с другими слогами. Правильное ударение критически важно для понимания.",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Word stress pairs section
        Text(
            text = "Пары слов с разным ударением",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StressPairCard(
                noun = "REcord",
                nounMeaning = "запись (существительное)",
                verb = "reCORD",
                verbMeaning = "записывать (глагол)"
            )

            StressPairCard(
                noun = "PREsent",
                nounMeaning = "подарок (существительное)",
                verb = "preSENT",
                verbMeaning = "представлять (глагол)"
            )

            StressPairCard(
                noun = "OBject",
                nounMeaning = "предмет (существительное)",
                verb = "obJECT",
                verbMeaning = "возражать (глагол)"
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Practice section
        Text(
            text = "Упражнения для практики",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        StressExercise(
            title = "Повторение пар слов",
            instructions = "Произнесите следующие пары слов, обращая внимание на разницу в ударении:",
            wordPairs = listOf(
                "REbel (мятежник) - reBEL (восставать)",
                "CONduct (поведение) - conDUCT (проводить)",
                "CONtract (договор) - conTRACT (сокращаться)",
                "CONvert (обращенный) - conVERT (обращать)",
                "DEsert (пустыня) - deSERT (покидать)"
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        StressExercise(
            title = "Практика в предложениях",
            instructions = "Произнесите эти предложения, обращая внимание на ударение:",
            sentences = listOf(
                "I need to REcord a reCORD for my music class.",
                "Please PREsent your preSENT to the birthday girl.",
                "That OBject might obJECT to being moved."
            )
        )
    }
}

@Composable
fun StressPairCard(
    noun: String,
    nounMeaning: String,
    verb: String,
    verbMeaning: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(0.8f),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF3E5F5))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = buildAnnotatedString {
                        noun.forEachIndexed { index, c ->
                            if (c.isUpperCase()) {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold, fontSize = 24.sp)) {
                                    append(c)
                                }
                            } else {
                                withStyle(style = SpanStyle(fontSize = 20.sp)) {
                                    append(c)
                                }
                            }
                        }
                    },
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = nounMeaning,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Divider(
                modifier = Modifier
                    .height(70.dp)
                    .width(1.dp)
                    .background(Color.Gray.copy(alpha = 0.3f))
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = buildAnnotatedString {
                        verb.forEachIndexed { index, c ->
                            if (c.isUpperCase()) {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold, fontSize = 24.sp)) {
                                    append(c)
                                }
                            } else {
                                withStyle(style = SpanStyle(fontSize = 20.sp)) {
                                    append(c)
                                }
                            }
                        }
                    },
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = verbMeaning,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun StressExercise(
    title: String,
    instructions: String,
    wordPairs: List<String> = emptyList(),
    sentences: List<String> = emptyList()
) {
    Card(
        modifier = Modifier.fillMaxWidth(0.8f),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE1F5FE))
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

            if (wordPairs.isNotEmpty()) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    wordPairs.forEach { pair ->
                        Surface(
                            modifier = Modifier.fillMaxWidth(0.9f),
                            color = Color.White,
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = pair,
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.padding(10.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }

            if (sentences.isNotEmpty()) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    sentences.forEach { sentence ->
                        Surface(
                            modifier = Modifier.fillMaxWidth(0.9f),
                            color = Color.White,
                            shape = RoundedCornerShape(4.dp)
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
