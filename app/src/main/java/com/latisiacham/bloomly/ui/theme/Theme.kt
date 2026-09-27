package com.latisiacham.bloomly.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = BloomlyPink,
    onPrimary = BloomlyCharcoal,
    secondary = BloomlyGreen,
    onSecondary = Color.White,
    background = BloomlyCharcoal,
    onBackground = BloomlyMint,
    surface = BloomlyCharcoal,
    onSurface = BloomlyMint
)

private val LightColorScheme = lightColorScheme(
    primary = BloomlyGreen,
    onPrimary = Color.White,
    secondary = BloomlyPink,
    onSecondary = Color.White,
    tertiary = BloomlyBlush,
    onTertiary = BloomlyCharcoal,
    background = BloomlyMint,
    onBackground = BloomlyCharcoal,
    surface = Color.White,
    onSurface = BloomlyCharcoal
)

@Composable
fun BloomlyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}