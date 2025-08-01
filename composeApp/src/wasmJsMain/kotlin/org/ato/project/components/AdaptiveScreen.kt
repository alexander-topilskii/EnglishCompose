package org.ato.project.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * A responsive screen template with adaptive layout based on screen width.
 *
 * @param title The title of the screen shown in the top bar
 * @param onBack Optional callback for back navigation
 * @param footerText Optional text to display in the footer
 * @param content Content to display inside the screen - receives current layout orientation and screen width
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdaptiveScreen(
    title: String,
    onBack: (() -> Unit)? = null,
    footerText: String? = null,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.(isVerticalLayout: Boolean, screenWidth: Dp) -> Unit
) {
    val density = LocalDensity.current
    var screenWidth by remember { mutableStateOf(0.dp) }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    onBack?.let {

                        IconButton(onClick = onBack) {
                            Text("←")
                        }
                    }
                },
                title = { Text(title) },
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .onSizeChanged { size ->
                        with(density) {
                            screenWidth = size.width.toDp()
                        }
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Determine if vertical layout (mobile-like layout is < 768dp)
                val isVerticalLayout = screenWidth < 768.dp

                // Main content area
                Box(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    content(isVerticalLayout, screenWidth)
                }
            }
        },
        bottomBar = {
            footerText?.let {
                BottomAppBar {
                    Text(
                        footerText,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp
                    )
                }
            }
        }
    )
}

/**
 * A layout component that adapts between vertical (column) and horizontal (row) layouts
 * based on the screen size.
 */
@Composable
fun AdaptiveLayout(
    isVerticalLayout: Boolean,
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    content: @Composable BoxScope.() -> Unit
) {
    if (isVerticalLayout) {
        Column(
            modifier = modifier.padding(16.dp),
            verticalArrangement = verticalArrangement,
            horizontalAlignment = horizontalAlignment
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
                content = content
            )
        }
    } else {
        Row(
            modifier = modifier.padding(16.dp),
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = verticalAlignment
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
                content = content
            )
        }
    }
}
