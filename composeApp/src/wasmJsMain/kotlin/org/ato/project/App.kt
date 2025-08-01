package org.ato.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.ato.project.screens.home.HomeScreen
import org.ato.project.screens.details.DetailsScreen
import org.ato.project.screens.idioms.IdiomsPage
import org.ato.project.screens.pronunciation.*
import org.ato.project.screens.pronunciation.lessons.*
import org.ato.project.screens.words.*
import org.ato.project.navigation.NavigationHandler
import org.ato.project.navigation.navigateWithHistory
import org.ato.project.navigation.goBackWithHistory
import kotlinx.browser.window
import org.w3c.dom.events.Event
import kotlin.js.JsAny

@Composable
fun App() {
    Configure()

    MaterialTheme {
        var userName by remember { mutableStateOf<String?>(null) }
        LaunchedEffect(firebaseApp) {
            if (firebaseApp != null) {
                userName = getUserDisplayName()
            }
        }

        val navController = rememberNavController()

        // Integrate browser history so the device back button navigates
        // through the app instead of closing it.
        LaunchedEffect(Unit) {
            window.history.replaceState(null, "", "#home")
        }
        DisposableEffect(navController) {
            val listener: (Event) -> Unit = {
                navController.popBackStack()
            }
            window.addEventListener("popstate", listener)
            onDispose { window.removeEventListener("popstate", listener) }
        }

        NavHost(navController = navController, startDestination = "home") {
            // Home screen
            composable("home") {
                HomeScreen(
                    onNavigateToDetails = { navController.navigateWithHistory("idioms") },
                    onNavigateToExamples = { navController.navigateWithHistory("vowels") },
                    onNavigateToVerbs = { navController.navigateWithHistory("verbs") },
                    onNavigateToAdjectives = { navController.navigateWithHistory("adjectives") },
                    onNavigateToNouns = { navController.navigateWithHistory("nouns") },
                    navController = navController,
                    userName = userName,
                    isLoggedIn = userName != null,
                    onLogin = {
                        loginWithGoogle { success ->
                            if (success) {
                                userName = getUserDisplayName()
                            }
                        }
                    },
                    onLogout = {
                        logout { success ->
                            if (success) {
                                userName = null
                            }
                        }
                    }

                )
            }

            // Idioms pages
            composable("idioms") {
                IdiomsPage(onBack = { navController.goBackWithHistory() })
            }

            // Pronunciation navigation pages
            composable("vowels") {
                val navigationHandler = NavigationHandler(navController)
                VowelsPage(
                    onBack = { navController.goBackWithHistory() },
                    onNavigateToLesson = { lessonId ->
                        navController.navigateWithHistory("lesson-$lessonId")
                    }
                )
            }
            composable("diphthongs") {
                val navigationHandler = NavigationHandler(navController)
                DiphthongsPage(
                    onBack = { navController.goBackWithHistory() },
                    onNavigateToLesson = { lessonId ->
                        navController.navigateWithHistory("lesson-$lessonId")
                    }
                )
            }
            composable("consonants") {
                val navigationHandler = NavigationHandler(navController)
                ConsonantsPage(
                    onBack = { navController.goBackWithHistory() },
                    onNavigateToLesson = { lessonId ->
                        navController.navigateWithHistory("lesson-$lessonId")
                    }
                )
            }
            composable("word-stress") {
                val navigationHandler = NavigationHandler(navController)
                WordStressPage(
                    onBack = { navController.goBackWithHistory() },
                    onNavigateToLesson = { lessonId ->
                        navController.navigateWithHistory("lesson-$lessonId")
                    }
                )
            }
            composable("intonation") {
                val navigationHandler = NavigationHandler(navController)
                IntonationPage(
                    onBack = { navController.goBackWithHistory() },
                    onNavigateToLesson = { lessonId ->
                        navController.navigateWithHistory("lesson-$lessonId")
                    }
                )
            }
            composable("russian-comparison") {
                val navigationHandler = NavigationHandler(navController)
                RussianComparisonPage(
                    onBack = { navController.goBackWithHistory() },
                    onNavigateToLesson = { lessonId ->
                        navController.navigateWithHistory("lesson-$lessonId")
                    }
                )
            }

            // Pronunciation lesson pages - Short Vowels
            composable("lesson-short-vowels-1") {
                ShortVowel1Lesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-i-sound") {
                IShortSoundLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-ae-sound") {
                AeSoundLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-e-sound") {
                EShortSoundLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-short-vowels-2") {
                ShortVowel2Lesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-schwa-sound") {
                SchwaLesson(onBack = { navController.goBackWithHistory() })
            }

            // Pronunciation lesson pages - Long Vowels
            composable("lesson-long-vowels-1") {
                LongVowel1Lesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-i-long-sound") {
                ILongSoundLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-u-long-sound") {
                ULongSoundLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-er-long-sound") {
                ErLongSoundLesson(onBack = { navController.goBackWithHistory() })
            }

            // Pronunciation lesson pages - Other Vowels
            composable("lesson-other-vowels-1") {
                OtherVowels1Lesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-uh-sound") {
                UhSoundLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-o-short-sound") {
                OShortSoundLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-o-long-sound") {
                OLongSoundLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-a-long-sound") {
                ALongSoundLesson(onBack = { navController.goBackWithHistory() })
            }

            // Pronunciation lesson pages - Diphthongs
            composable("lesson-centering-diphthongs-1") {
                CenteringDiphthongs1Lesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-ir-diphthong") {
                IrDiphthongLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-er-diphthong") {
                ErDiphthongLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-ur-diphthong") {
                UrDiphthongLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-closing-diphthongs-1") {
                ClosingDiphthongs1Lesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-ei-diphthong") {
                EiDiphthongLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-ai-diphthong") {
                AiDiphthongLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-oi-diphthong") {
                OiDiphthongLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-ou-diphthong") {
                OuDiphthongLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-au-diphthong") {
                AuDiphthongLesson(onBack = { navController.goBackWithHistory() })
            }

            // Pronunciation lesson pages - Consonants
            composable("lesson-plosives-1") {
                PlosivesLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-p-b-pair") {
                PBPairLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-t-d-pair") {
                TDPairLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-k-g-pair") {
                KGPairLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-fricatives-1") {
                FricativesLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-th-voiced-voiceless") {
                ThVoicedVoicelessLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-s-z-pair") {
                SZPairLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-sh-zh-pair") {
                ShZhPairLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-affricates-1") {
                AffricatesLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-nasals-approx-1") {
                NasalsApproximantsLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-l-sound") {
                LSoundLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-r-sound") {
                RSoundLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-ng-sound") {
                NgSoundLesson(onBack = { navController.goBackWithHistory() })
            }

            // Pronunciation lesson pages - Stress and Rhythm
            composable("lesson-word-stress-1") {
                WordStressLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-sentence-rhythm-1") {
                SentenceRhythmLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-stress-pairs") {
                StressPairsLesson(onBack = { navController.goBackWithHistory() })
            }

            // Pronunciation lesson pages - Intonation
            composable("lesson-rising-falling") {
                RisingFallingLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-linking-sounds") {
                LinkingSoundsLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-tongue-twisters") {
                TongueTwistersLesson(onBack = { navController.goBackWithHistory() })
            }

            // Pronunciation lesson pages - Russian Comparison
            composable("lesson-missing-sounds-1") {
                MissingSoundsLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-vowel-issues-1") {
                VowelIssuesLesson(onBack = { navController.goBackWithHistory() })
            }
            composable("lesson-correction-1") {
                CorrectionLesson(onBack = { navController.goBackWithHistory() })
            }

            // Words pages
            composable("verbs") {
                VerbsScreen(onBack = { navController.goBackWithHistory() })
            }
            composable("adjectives") {
                AdjectivesScreen(onBack = { navController.goBackWithHistory() })
            }
            composable("nouns") {
                NounsScreen(onBack = { navController.goBackWithHistory() })
            }
        }
    }
}



fun loginWithGoogle(onResult: (Boolean) -> Unit = {}) {
    try {
        println("Login with Google1")
        val auth = getAuth(firebaseApp)

        val provider = GoogleAuthProvider()
        println("Login with Google2")

        signInWithPopup(auth, provider).then({ _: JsAny ->
            println("Login successful ${getUserDisplayName()}")
            onResult(true)
            null
        }, { error: JsAny ->
            println("Login error: ${error ?: error.toString()}")
            onResult(false)
            null
        })
    } catch (e: Throwable) {
        println("Exception during login: ${e.message}")
        onResult(false)
    }
}

fun logout(onResult: (Boolean) -> Unit = {}) {
    try {
        val auth = getAuth(firebaseApp)
        signOut(auth).then({ _: JsAny ->
            onResult(true)
            null
        }, { error: JsAny ->
            println("Logout error: ${'$'}{error ?: error.toString()}")
            onResult(false)
            null
        })
    } catch (e: Throwable) {
        println("Exception during logout: ${'$'}{e.message}")
        onResult(false)
    }
}