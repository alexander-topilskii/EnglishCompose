package org.ato.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.ato.project.screens.HomeScreen
import org.ato.project.screens.details.DetailsScreen
import org.ato.project.screens.examples.ExamplesPage

@Composable
fun App() {
    MaterialTheme {
        // Remove column wrapper since HomeScreen now uses Scaffold
        // and has its own layout handling
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                HomeScreen(
                    onNavigateToDetails = { navController.navigate("details") },
                    onNavigateToExamples = { navController.navigate("examples") }
                )
            }
            composable("details") {
                DetailsScreen(onNavigateBack = { navController.popBackStack() })
            }
            composable("examples") {
                ExamplesPage(onBack = { navController.popBackStack() })
            }
        }
    }
}