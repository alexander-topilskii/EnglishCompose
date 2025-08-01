package org.ato.project

import kotlin.js.Promise

@JsModule("firebase/auth")
@JsName("getAuth")
external fun getAuth(app: JsAny? = definedExternally): JsAny

// Correct way to use GoogleAuthProvider in JS
@JsModule("firebase/auth")
external val GoogleAuthProvider: JsAny

@JsModule("firebase/auth")
@JsName("signInWithPopup")
external fun signInWithPopup(auth: JsAny, provider: JsAny): Promise<JsAny>

val provider: JsAny = js("new GoogleAuthProvider.GoogleAuthProvider()")

fun loginWithGoogle(onResult: (Boolean) -> Unit = {}) {
    try {
        val auth = getAuth(firebaseApp)
        // Create a new provider using JS interop

        signInWithPopup(auth, provider).then({ _: JsAny ->
//            println("Login successful")
            onResult(true)
            null
        }, { error: JsAny ->
//            println("Login error: ${error}")
            onResult(false)
            null
        })
    } catch (e: Throwable) {
//        println("Exception during login: ${e.message}")
        e.printStackTrace()
        onResult(false)
    }
}
