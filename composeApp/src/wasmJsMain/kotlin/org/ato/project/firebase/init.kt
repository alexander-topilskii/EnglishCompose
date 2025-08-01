@file:JsModule("firebase/app")
package org.ato.project.firebase

import kotlin.js.JsAny

// Separate file, e.g., FirebaseAppInterop.kt

@JsName("initializeApp")
external fun initializeApp(config: JsAny): JsAny
