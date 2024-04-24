package ru.aaprokin.store.core.compose.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

object AppTheme {
    val Dimens: AppDimens
        @Composable
        get() = LocalDimens.current

    val Roundings: AppRoundings
        @Composable
        get() = LocalRoundings.current

    val Colors: AppColors
        @Composable
        get() = LocalColors.current

    /**
     * Из-за шрифта не будет работать превью.
     */
    val TextStyles: AppTextStyles
        @Composable
        get() = LocalTextStyles.current
}

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val rippleTheme = HackedRippleTheme
    val dimens = defaultDimens
    val roundings = defaultRoundings
    val colors = defaultColors
    val textStyles = defaultTextStyles

    MaterialTheme {
        CompositionWrapper(
            dimens = dimens,
            roundings = roundings,
            colors = colors,
            textStyles = textStyles,
            rippleTheme = rippleTheme,
            content = content
        )
    }
}

private object HackedRippleTheme : RippleTheme {

    private val hackedRippleColor = Color(0xFFC1C1C1)

    @Composable
    override fun defaultColor(): Color = hackedRippleColor

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
        contentColor = hackedRippleColor,
        lightTheme = true
    )
}

@Composable
private fun CompositionWrapper(
    dimens: AppDimens,
    roundings: AppRoundings,
    colors: AppColors,
    textStyles: AppTextStyles,
    rippleTheme: RippleTheme,
    content: @Composable () -> Unit
) {
    val dimensCalculation = remember { dimens }
    val roundingsCalculation = remember { roundings }
    val colorsCalculation = remember { colors }
    val textStylesCalculation = remember { textStyles }
    val rippleThemeCalculation = remember { rippleTheme }
    CompositionLocalProvider(
        LocalDimens provides dimensCalculation,
        LocalRoundings provides roundingsCalculation,
        LocalColors provides colorsCalculation,
        LocalTextStyles provides textStylesCalculation,
        LocalRippleTheme provides rippleThemeCalculation,
//        LocalOverscrollConfiguration provides null, TODO build error
        content = content
    )
}

private val LocalDimens = staticCompositionLocalOf {
    defaultDimens
}

private val LocalRoundings = staticCompositionLocalOf {
    defaultRoundings
}

private val LocalColors = staticCompositionLocalOf {
    defaultColors
}

private val LocalTextStyles = staticCompositionLocalOf {
    defaultTextStyles
}
