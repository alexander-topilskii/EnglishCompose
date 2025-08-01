package org.ato.project.screens.pronunciation.lessons

import androidx.compose.runtime.Composable

@Composable
fun PlosivesLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Взрывные согласные",
        subtitle = "Взрывные согласные (/p/, /b/, /t/, /d/, /k/, /g/) — аспирация и практика",
        onBack = onBack
    )
}

@Composable
fun PBPairLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/p/ vs /b/",
        subtitle = "Минимальные пары (pin/bin, cap/cab)",
        onBack = onBack
    )
}

@Composable
fun TDPairLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/t/ vs /d/",
        subtitle = "Минимальные пары (ten/den, bat/bad)",
        onBack = onBack
    )
}

@Composable
fun KGPairLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/k/ vs /g/",
        subtitle = "Минимальные пары (cat/gat, back/bag)",
        onBack = onBack
    )
}

@Composable
fun FricativesLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Фрикативные согласные",
        subtitle = "Фрикативные согласные (/f/, /v/, /θ/, /ð/, /s/, /z/, /ʃ/, /ʒ/, /h/) — практика",
        onBack = onBack
    )
}

@Composable
fun ThVoicedVoicelessLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/θ/ vs /ð/",
        subtitle = "Минимальные пары (think/this, bath/bathe)",
        onBack = onBack
    )
}

@Composable
fun SZPairLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/s/ vs /z/",
        subtitle = "Минимальные пары (bus/buzz, ice/eyes)",
        onBack = onBack
    )
}

@Composable
fun ShZhPairLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/ʃ/ vs /ʒ/",
        subtitle = "Минимальные пары (ship/genre, pressure/pleasure)",
        onBack = onBack
    )
}

@Composable
fun AffricatesLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Аффрикаты",
        subtitle = "Аффрикаты (/tʃ/, /dʒ/) — практика (church/judge, cheap/jeep)",
        onBack = onBack
    )
}

@Composable
fun NasalsApproximantsLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "Носовые и аппроксиманты",
        subtitle = "(/m/, /n/, /ŋ/, /l/, /r/, /w/, /j/) — практика",
        onBack = onBack
    )
}

@Composable
fun LSoundLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/l/ — звук",
        subtitle = "Светлый и темный варианты (light/dark l)",
        onBack = onBack
    )
}

@Composable
fun RSoundLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/r/ — звук",
        subtitle = "Американский и британский варианты",
        onBack = onBack
    )
}

@Composable
fun NgSoundLesson(onBack: () -> Unit) {
    BaseLessonScreen(
        title = "/ŋ/ — звук",
        subtitle = "Практика (sing, ring, thing)",
        onBack = onBack
    )
}
