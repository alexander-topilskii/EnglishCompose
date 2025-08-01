// Separate file, e.g., FirebaseAnalyticsInterop.kt
@file:JsModule("firebase/analytics")
package org.ato.project.firebase

import kotlin.js.JsAny

@JsName("getAnalytics")
external fun getAnalytics(app: JsAny?): JsAny
