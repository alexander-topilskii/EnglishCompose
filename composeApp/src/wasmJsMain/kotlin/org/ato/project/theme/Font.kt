package org.ato.project.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

/**
 * Font utility class for handling phonetic symbols
 */
object PhoneticFont {
    // Use default sans-serif font which will be styled with Noto Sans via CSS
    val fontFamily = FontFamily.SansSerif

    /**
     * Creates a span style for phonetic symbols
     */
    fun phoneticStyle(style: TextStyle): SpanStyle {
        return SpanStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = style.fontSize,
            color = style.color
        )
    }

    /**
     * Utility function to create text with properly styled phonetic symbols
     */
    @Composable
    fun PhoneticText(
        text: String,
        baseStyle: TextStyle,
        modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier
    ) {
        // Text content with phonetic symbols wrapped in special style
        val annotatedString = buildAnnotatedString {
            withStyle(phoneticStyle(baseStyle)) {
                append(text)
            }
        }

        androidx.compose.material3.Text(
            text = annotatedString,
            style = baseStyle,
            modifier = modifier
        )
    }
}
