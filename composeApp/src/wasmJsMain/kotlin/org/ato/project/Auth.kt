@file:JsModule("firebase/auth")

package org.ato.project

import kotlin.js.Promise


@JsName("getAuth")
external fun getAuth(app: JsAny? = definedExternally): JsAny

@JsName("signInWithPopup")
external fun signInWithPopup(auth: JsAny, provider: JsAny): Promise<JsAny>

@JsName("GoogleAuthProvider")
external class GoogleAuthProvider : JsAny
