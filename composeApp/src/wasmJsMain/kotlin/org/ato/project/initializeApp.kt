package org.ato.project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

var firebaseApp: JsAny? = null
@JsModule("firebase/app")
external fun initializeApp(config: JsAny): JsAny

@JsModule("firebase/analytics")
external fun getAnalytics(app: JsAny?): JsAny

val createFirebaseConfig: JsAny = js(
    """
    ({
        apiKey: "AIzaSyCDXfWroX-TY1PDhi57wd2p-NXCcNQ9-Rg",
        authDomain: "english-7f9bd.firebaseapp.com",
        projectId: "english-7f9bd",
        storageBucket: "english-7f9bd.firebasestorage.app",
        messagingSenderId: "506527798417",
        appId: "1:506527798417:web:edaa37554e2f820a785b30",
        measurementId: "G-23272SW35H"
    })
    """
)

@Composable
fun Configure() {
    LaunchedEffect(Unit) {
        try {
            firebaseApp = initializeApp(createFirebaseConfig)
            val analytics = getAnalytics(firebaseApp)
            println("Firebase initialized successfully")
        } catch (e: Throwable) {
            println("Firebase init error: ${e.message}")
        }
    }
}