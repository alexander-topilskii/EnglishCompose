package org.ato.project.navigation

import androidx.navigation.NavController
import kotlinx.browser.window

/**
 * Utilities to sync navigation with the browser history so that the
 * device back button navigates within the app instead of exiting.
 */
fun NavController.navigateWithHistory(route: String) {
    window.history.pushState(null, "", "#${'$'}route")
    this.navigate(route)
}

fun NavController.goBackWithHistory() {
    if (window.history.length > 1) {
        window.history.back() // This will trigger the popstate listener
    } else {
        this.popBackStack()
    }
}
