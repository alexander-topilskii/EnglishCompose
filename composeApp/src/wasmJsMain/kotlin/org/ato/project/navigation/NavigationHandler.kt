package org.ato.project.navigation

import androidx.navigation.NavController

/**
 * Utility class to handle navigation between screens
 */
class NavigationHandler(private val navController: NavController) {

    fun navigateToVowelsLesson() {
        navController.navigate("short-vowels-lesson")
    }

    fun navigateToConsonantsLesson() {
        navController.navigate("voiceless-consonants-lesson")
    }

    fun navigateToConsonantClustersLesson() {
        navController.navigate("consonant-clusters-lesson")
    }

    fun navigateToWordStressLesson() {
        navController.navigate("word-stress-lesson")
    }

    fun navigateBack() {
        navController.popBackStack()
    }
}
