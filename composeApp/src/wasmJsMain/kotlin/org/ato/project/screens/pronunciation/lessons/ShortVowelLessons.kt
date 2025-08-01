package org.ato.project.screens.pronunciation.lessons

import androidx.compose.runtime.Composable

@Composable
fun ShortVowel1Lesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Короткие гласные",
        subtitle = "Короткие гласные (/ɪ/, /æ/, /e/) — практика минимальных пар",
        onBack = onBack
    )
}

@Composable
fun IShortSoundLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/ɪ/ — звук",
        subtitle = "Практика минимальных пар (ship/sheep, bit/beat)",
        onBack = onBack
    )
}

@Composable
fun AeSoundLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/æ/ — звук",
        subtitle = "Практика минимальных пар (cat/cut, bad/bed)",
        onBack = onBack
    )
}

@Composable
fun EShortSoundLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/e/ — звук",
        subtitle = "Практика минимальных пар (bed/bad, pen/pin)",
        onBack = onBack
    )
}

@Composable
fun ShortVowel2Lesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Короткие гласные (/ʊ/, /ə/)",
        subtitle = "Произношение и различение",
        onBack = onBack
    )
}

@Composable
fun SchwaLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Шва (/ə/)",
        subtitle = "Роль в безударных слогах — практика редукции",
        onBack = onBack
    )
}
