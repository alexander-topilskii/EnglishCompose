package org.ato.project

import kotlin.js.Promise

@JsModule("firebase/auth")
@JsName("getAuth")
external fun getAuth(app: JsAny? = definedExternally): JsAny

@JsModule("firebase/auth")
external class GoogleAuthProvider

@JsModule("firebase/auth")
@JsName("signInWithPopup")
external fun signInWithPopup(auth: JsAny, provider: JsAny): Promise<JsAny>

fun loginWithGoogle(onResult: (Boolean) -> Unit = {}) {
    val auth = getAuth(firebaseApp)
    val provider = GoogleAuthProvider()
    signInWithPopup(auth, provider as JsAny).then({ _: JsAny ->
        println("Login successful")
        onResult(true)
        null
    }, { error: JsAny ->
        println("Login error: ${error}")
        onResult(false)
        null
    })
}
