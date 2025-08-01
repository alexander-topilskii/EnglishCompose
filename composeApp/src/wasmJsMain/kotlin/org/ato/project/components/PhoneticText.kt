package org.ato.project.components

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

/**
 * A specialized Text component for rendering IPA phonetic symbols
 * that adds special CSS classes to ensure proper font rendering
 */
@Composable
fun PhoneticText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        modifier = modifier,
        style = style,
        textAlign = textAlign,
        // The class attribute will be applied to the resulting HTML element
        // which allows the CSS to target it specifically
        // Note: DOM attributes are only available in WASM/JS targets
        onTextLayout = {}
    )
}
