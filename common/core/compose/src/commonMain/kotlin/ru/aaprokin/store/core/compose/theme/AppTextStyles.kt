package ru.aaprokin.store.core.compose.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import store.common.core.compose.generated.resources.Res
import store.common.core.compose.generated.resources.sf_pro_medium
import store.common.core.compose.generated.resources.sf_pro_regular

@OptIn(ExperimentalResourceApi::class)
data object AppTextStyles {

    private val SFPro: FontFamily
        @Composable
        get() = FontFamily(
            Font(Res.font.sf_pro_regular),
            Font(Res.font.sf_pro_medium, FontWeight.W500),
        )

    val header1: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = SFPro,
            fontWeight = FontWeight.W500,
            fontSize = 28.sp,
            lineHeight = 34.sp
        )

    val header2: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = SFPro,
            fontWeight = FontWeight.W500,
            fontSize = 28.sp,
            lineHeight = 34.sp
        )

    val header3: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = SFPro,
            fontWeight = FontWeight.W500,
            fontSize = 18.sp,
            lineHeight = 22.sp
        )

    val header4: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = SFPro,
            fontWeight = FontWeight.W500,
            fontSize = 16.sp,
            lineHeight = 22.sp,
        )

    val text1: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = SFPro,
            fontSize = 16.sp,
            lineHeight = 22.sp
        )

    val text2: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = SFPro,
            fontSize = 16.sp,
            lineHeight = 22.sp
        )

    val caption1: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = SFPro,
            fontSize = 12.sp,
            lineHeight = 16.sp
        )

    val caption2: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = SFPro,
            fontSize = 10.sp,
            lineHeight = 12.sp
        )

    val buttonM: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = SFPro,
            fontSize = 16.sp,
            lineHeight = 22.sp
        )

    val buttonS: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = SFPro,
            fontSize = 14.sp,
            lineHeight = 20.sp
        )
}

internal val defaultTextStyles = AppTextStyles
