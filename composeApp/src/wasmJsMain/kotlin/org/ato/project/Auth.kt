@file:JsModule("firebase/auth")
package org.ato.project

import kotlin.js.JsAny
import kotlin.js.Promise

@JsName("getAuth")
external fun getAuth(app: JsAny? = definedExternally): JsAny

@JsName("signInWithPopup")
external fun signInWithPopup(auth: JsAny, provider: JsAny): Promise<JsAny>

@JsName("signOut")
external fun signOut(auth: JsAny): Promise<JsAny>

@JsName("GoogleAuthProvider")
external class GoogleAuthProvider : JsAny

external interface FirebaseAuth : JsAny {
    val currentUser: FirebaseUser?
}

external interface FirebaseUser : JsAny {
    val displayName: String?
}
