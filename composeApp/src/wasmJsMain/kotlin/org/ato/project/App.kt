package org.ato.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
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
import org.ato.project.loginWithGoogle
import kotlin.js.JsAny

@Composable
fun App() {
    Configure()

    MaterialTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "home") {
            // Home screen
            composable("home") {
                HomeScreen(
                    onNavigateToDetails = { navController.navigate("idioms") },
                    onNavigateToExamples = { navController.navigate("vowels") },
                    onNavigateToVerbs = { navController.navigate("verbs") },
                    onNavigateToAdjectives = { navController.navigate("adjectives") },
                    onNavigateToNouns = { navController.navigate("nouns") },
                    navController = navController,

                    onLogin = {
                        println("sdfdsfsd")
                        loginWithGoogle()
                        println("sds : ${getUserDisplayName()}")
                    }

                    

                )
            }

            // Idioms pages
            composable("idioms") {
                IdiomsPage(onBack = { navController.popBackStack() })
            }

            // Pronunciation navigation pages
            composable("vowels") {
                val navigationHandler = NavigationHandler(navController)
                VowelsPage(
                    onBack = { navController.popBackStack() },
                    onNavigateToLesson = { lessonId ->
                        navController.navigate("lesson-$lessonId")
                    }
                )
            }
            composable("diphthongs") {
                val navigationHandler = NavigationHandler(navController)
                DiphthongsPage(
                    onBack = { navController.popBackStack() },
                    onNavigateToLesson = { lessonId ->
                        navController.navigate("lesson-$lessonId")
                    }
                )
            }
            composable("consonants") {
                val navigationHandler = NavigationHandler(navController)
                ConsonantsPage(
                    onBack = { navController.popBackStack() },
                    onNavigateToLesson = { lessonId ->
                        navController.navigate("lesson-$lessonId")
                    }
                )
            }
            composable("word-stress") {
                val navigationHandler = NavigationHandler(navController)
                WordStressPage(
                    onBack = { navController.popBackStack() },
                    onNavigateToLesson = { lessonId ->
                        navController.navigate("lesson-$lessonId")
                    }
                )
            }
            composable("intonation") {
                val navigationHandler = NavigationHandler(navController)
                IntonationPage(
                    onBack = { navController.popBackStack() },
                    onNavigateToLesson = { lessonId ->
                        navController.navigate("lesson-$lessonId")
                    }
                )
            }
            composable("russian-comparison") {
                val navigationHandler = NavigationHandler(navController)
                RussianComparisonPage(
                    onBack = { navController.popBackStack() },
                    onNavigateToLesson = { lessonId ->
                        navController.navigate("lesson-$lessonId")
                    }
                )
            }

            // Pronunciation lesson pages - Short Vowels
            composable("lesson-short-vowels-1") {
                ShortVowel1Lesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-i-sound") {
                IShortSoundLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-ae-sound") {
                AeSoundLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-e-sound") {
                EShortSoundLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-short-vowels-2") {
                ShortVowel2Lesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-schwa-sound") {
                SchwaLesson(onBack = { navController.popBackStack() })
            }

            // Pronunciation lesson pages - Long Vowels
            composable("lesson-long-vowels-1") {
                LongVowel1Lesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-i-long-sound") {
                ILongSoundLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-u-long-sound") {
                ULongSoundLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-er-long-sound") {
                ErLongSoundLesson(onBack = { navController.popBackStack() })
            }

            // Pronunciation lesson pages - Other Vowels
            composable("lesson-other-vowels-1") {
                OtherVowels1Lesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-uh-sound") {
                UhSoundLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-o-short-sound") {
                OShortSoundLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-o-long-sound") {
                OLongSoundLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-a-long-sound") {
                ALongSoundLesson(onBack = { navController.popBackStack() })
            }

            // Pronunciation lesson pages - Diphthongs
            composable("lesson-centering-diphthongs-1") {
                CenteringDiphthongs1Lesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-ir-diphthong") {
                IrDiphthongLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-er-diphthong") {
                ErDiphthongLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-ur-diphthong") {
                UrDiphthongLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-closing-diphthongs-1") {
                ClosingDiphthongs1Lesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-ei-diphthong") {
                EiDiphthongLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-ai-diphthong") {
                AiDiphthongLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-oi-diphthong") {
                OiDiphthongLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-ou-diphthong") {
                OuDiphthongLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-au-diphthong") {
                AuDiphthongLesson(onBack = { navController.popBackStack() })
            }

            // Pronunciation lesson pages - Consonants
            composable("lesson-plosives-1") {
                PlosivesLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-p-b-pair") {
                PBPairLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-t-d-pair") {
                TDPairLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-k-g-pair") {
                KGPairLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-fricatives-1") {
                FricativesLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-th-voiced-voiceless") {
                ThVoicedVoicelessLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-s-z-pair") {
                SZPairLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-sh-zh-pair") {
                ShZhPairLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-affricates-1") {
                AffricatesLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-nasals-approx-1") {
                NasalsApproximantsLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-l-sound") {
                LSoundLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-r-sound") {
                RSoundLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-ng-sound") {
                NgSoundLesson(onBack = { navController.popBackStack() })
            }

            // Pronunciation lesson pages - Stress and Rhythm
            composable("lesson-word-stress-1") {
                WordStressLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-sentence-rhythm-1") {
                SentenceRhythmLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-stress-pairs") {
                StressPairsLesson(onBack = { navController.popBackStack() })
            }

            // Pronunciation lesson pages - Intonation
            composable("lesson-rising-falling") {
                RisingFallingLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-linking-sounds") {
                LinkingSoundsLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-tongue-twisters") {
                TongueTwistersLesson(onBack = { navController.popBackStack() })
            }

            // Pronunciation lesson pages - Russian Comparison
            composable("lesson-missing-sounds-1") {
                MissingSoundsLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-vowel-issues-1") {
                VowelIssuesLesson(onBack = { navController.popBackStack() })
            }
            composable("lesson-correction-1") {
                CorrectionLesson(onBack = { navController.popBackStack() })
            }

            // Words pages
            composable("verbs") {
                VerbsScreen(onBack = { navController.popBackStack() })
            }
            composable("adjectives") {
                AdjectivesScreen(onBack = { navController.popBackStack() })
            }
            composable("nouns") {
                NounsScreen(onBack = { navController.popBackStack() })
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