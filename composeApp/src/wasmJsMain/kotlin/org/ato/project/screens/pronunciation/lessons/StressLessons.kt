package org.ato.project.screens.pronunciation.lessons

import androidx.compose.runtime.Composable

@Composable
fun WordStressLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Словесное ударение",
        subtitle = "Правила и практика",
        onBack = onBack
    )
}

@Composable
fun SentenceRhythmLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Ритм предложений",
        subtitle = "Сильные и слабые слоги, редукция",
        onBack = onBack
    )
}

@Composable
fun StressPairsLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Практика на минимальных парах с ударением",
        subtitle = "record (сущ.) vs record (глагол)",
        onBack = onBack
    )
}
