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
import org.ato.project.screens.words.*
import org.ato.project.navigation.NavigationHandler

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
                    onNavigateToNouns = { navController.navigate("nouns") }
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
                        when (lessonId) {
                            "short-vowels-1" -> navigationHandler.navigateToVowelsLesson()
                            // Add other lesson IDs as needed
                        }
                    }
                )
            }
            composable("consonants") {
                val navigationHandler = NavigationHandler(navController)
                ConsonantsPage(
                    onBack = { navController.popBackStack() },
                    onNavigateToLesson = { lessonId ->
                        when (lessonId) {
                            "voiceless-1" -> navigationHandler.navigateToConsonantsLesson()
                            // Add other lesson IDs as needed
                        }
                    }
                )
            }
            composable("consonant-clusters") {
                val navigationHandler = NavigationHandler(navController)
                ConsonantClustersPage(
                    onBack = { navController.popBackStack() },
                    onNavigateToLesson = { lessonId ->
                        when (lessonId) {
                            "initial-1" -> navigationHandler.navigateToConsonantClustersLesson()
                            // Add other lesson IDs as needed
                        }
                    }
                )
            }
            composable("word-stress") {
                val navigationHandler = NavigationHandler(navController)
                WordStressPage(
                    onBack = { navController.popBackStack() },
                    onNavigateToLesson = { lessonId ->
                        when (lessonId) {
                            "basics-1" -> navigationHandler.navigateToWordStressLesson()
                            // Add other lesson IDs as needed
                        }
                    }
                )
            }

            // Pronunciation lesson pages
            composable("short-vowels-lesson") {
                ShortVowelsLessonScreen(onBack = { navController.popBackStack() })
            }
            composable("voiceless-consonants-lesson") {
                VoicelessConsonantsLessonScreen(onBack = { navController.popBackStack() })
            }
            composable("consonant-clusters-lesson") {
                ConsonantClustersLessonScreen(onBack = { navController.popBackStack() })
            }
            composable("word-stress-lesson") {
                WordStressLessonScreen(onBack = { navController.popBackStack() })
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
