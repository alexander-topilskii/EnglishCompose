@file:JsModule("firebase/app")
package org.ato.project.firebase


// Separate file, e.g., FirebaseAppInterop.kt

@JsName("initializeApp")
external fun initializeApp(config: JsAny): JsAny