package org.ato.project.screens.pronunciation.lessons

import androidx.compose.runtime.Composable

@Composable
fun LongVowel1Lesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Длинные гласные",
        subtitle = "Длинные гласные (/i:/, /u:/, /ɜ:/) — практика произношения",
        onBack = onBack
    )
}

@Composable
fun ILongSoundLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/i:/ — звук",
        subtitle = "Практика минимальных пар (sheep/ship, beat/bit)",
        onBack = onBack
    )
}

@Composable
fun ULongSoundLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/u:/ — звук",
        subtitle = "Практика минимальных пар (pool/pull, food/foot)",
        onBack = onBack
    )
}

@Composable
fun ErLongSoundLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/ɜ:/ — звук",
        subtitle = "Практика минимальных пар (bird/bad, fur/far)",
        onBack = onBack
    )
}
