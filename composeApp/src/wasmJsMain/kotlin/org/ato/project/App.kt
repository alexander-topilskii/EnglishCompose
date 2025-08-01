package org.ato.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.ato.project.screens.home.HomeScreen
import org.ato.project.screens.details.DetailsScreen
import org.ato.project.screens.examples.ExamplesPage

@Composable
fun App() {
    Configure()

    MaterialTheme {
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
