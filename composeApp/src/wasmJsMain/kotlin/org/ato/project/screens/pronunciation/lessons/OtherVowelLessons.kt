package org.ato.project.screens.pronunciation.lessons

import androidx.compose.runtime.Composable

@Composable
fun OtherVowels1Lesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Другие гласные",
        subtitle = "Другие гласные (/ʌ/, /ɒ/, /ɔ:/, /ɑ:/) — сравнение и практика",
        onBack = onBack
    )
}

@Composable
fun UhSoundLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/ʌ/ — звук",
        subtitle = "Практика (cut/cat, luck/lack)",
        onBack = onBack
    )
}

@Composable
fun OShortSoundLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/ɒ/ — звук",
        subtitle = "Практика (hot/hat, pot/pet)",
        onBack = onBack
    )
}

@Composable
fun OLongSoundLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/ɔ:/ — звук",
        subtitle = "Практика (thought/taught, law/low)",
        onBack = onBack
    )
}

@Composable
fun ALongSoundLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/ɑ:/ — звук",
        subtitle = "Практика (car/cat, father/further)",
        onBack = onBack
    )
}
