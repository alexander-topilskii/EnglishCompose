package org.ato.project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import org.ato.project.firebase.getAnalytics
import org.ato.project.firebase.initializeApp
import kotlin.js.JsAny



// In your main file
var firebaseApp: JsAny? = null

val firebaseConfig: JsAny = js("""
    ({
        apiKey: "AIzaSyCDXfWroX-TY1PDhi57wd2p-NXCcNQ9-Rg",
        authDomain: "english-7f9bd.firebaseapp.com",
        projectId: "english-7f9bd",
        storageBucket: "english-7f9bd.firebasestorage.app",
        messagingSenderId: "506527798417",
        appId: "1:506527798417:web:edaa37554e2f820a785b30",
        measurementId: "G-23272SW35H"
    })
""")

@Composable
fun Configure() {
    LaunchedEffect(Unit) {
        try {

            println("Firebase initialize..... $firebaseApp")
            // Debug: log the config
            firebaseApp = initializeApp(firebaseConfig)
            val analytics = getAnalytics(firebaseApp)
            println("Firebase initialized successfully $firebaseApp")

        } catch (e: Throwable) {
            println("Firebase init error: ${e.message}")
            // For more details
        }
    }
}

fun getUserDisplayName(): String? {
    val auth = getAuth(firebaseApp) as FirebaseAuth
    val currentUser = auth.currentUser
    return currentUser?.displayName
}