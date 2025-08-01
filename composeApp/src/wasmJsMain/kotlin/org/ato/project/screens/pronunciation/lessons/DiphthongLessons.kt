package org.ato.project.screens.pronunciation.lessons

import androidx.compose.runtime.Composable

@Composable
fun CenteringDiphthongs1Lesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Центрирующие дифтонги",
        subtitle = "Центрирующие дифтонги (/ɪə/, /eə/, /ʊə/) — практика",
        onBack = onBack
    )
}

@Composable
fun IrDiphthongLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/ɪə/ — дифтонг",
        subtitle = "Примеры: near, beer, fear",
        onBack = onBack
    )
}

@Composable
fun ErDiphthongLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/eə/ — дифтонг",
        subtitle = "Примеры: hair, care, there",
        onBack = onBack
    )
}

@Composable
fun UrDiphthongLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/ʊə/ — дифтонг",
        subtitle = "Примеры: tour, poor, sure",
        onBack = onBack
    )
}

@Composable
fun ClosingDiphthongs1Lesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Закрывающие дифтонги",
        subtitle = "Закрывающие дифтонги (/eɪ/, /aɪ/, /ɔɪ/, /əʊ/, /aʊ/) — практика",
        onBack = onBack
    )
}

@Composable
fun EiDiphthongLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/eɪ/ — дифтонг",
        subtitle = "Практика: day, face, rain",
        onBack = onBack
    )
}

@Composable
fun AiDiphthongLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/aɪ/ — дифтонг",
        subtitle = "Практика: time, high, my",
        onBack = onBack
    )
}

@Composable
fun OiDiphthongLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/ɔɪ/ — дифтонг",
        subtitle = "Практика: boy, coin, noise",
        onBack = onBack
    )
}

@Composable
fun OuDiphthongLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/əʊ/ — дифтонг",
        subtitle = "Практика: go, home, no",
        onBack = onBack
    )
}

@Composable
fun AuDiphthongLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/aʊ/ — дифтонг",
        subtitle = "Практика: now, out, house",
        onBack = onBack
    )
}
