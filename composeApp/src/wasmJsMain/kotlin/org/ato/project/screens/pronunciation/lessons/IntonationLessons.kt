package org.ato.project.screens.pronunciation.lessons

import androidx.compose.runtime.Composable

@Composable
fun RisingFallingLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Восходящая и нисходящая интонация",
        subtitle = "Вопросы и утверждения",
        onBack = onBack
    )
}

@Composable
fun LinkingSoundsLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Связывание звуков",
        subtitle = "linking, assimilation, elision",
        onBack = onBack
    )
}

@Composable
fun TongueTwistersLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Практика на скороговорках и диалогах",
        subtitle = "Развитие беглости речи",
        onBack = onBack
    )
}
