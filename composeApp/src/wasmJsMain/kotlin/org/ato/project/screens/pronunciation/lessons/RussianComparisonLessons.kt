package org.ato.project.screens.pronunciation.lessons

import androidx.compose.runtime.Composable

@Composable
fun MissingSoundsLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Звуки, отсутствующие в русском",
        subtitle = "/θ/, /ð/, /ŋ/, /h/",
        onBack = onBack
    )
}

@Composable
fun VowelIssuesLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Проблемы с гласными",
        subtitle = "Длина, качество",
        onBack = onBack
    )
}

@Composable
fun CorrectionLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Упражнения на коррекцию типичных ошибок",
        subtitle = "Для русскоязычных",
        onBack = onBack
    )
}
