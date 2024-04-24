package ru.aaprokin.store.core.compose.theme

import androidx.compose.ui.graphics.Color

data class AppColors(
    val backgroundBlack: Color,
    val surfacePrimary: Color,
    val surfaceSecondary: Color,
    val surfaceOnBlackBg: Color,
    val surfaceOpacityWhite: Color,
    val surfaceOpacityBlack: Color,

    val textPrimary: Color,
    val textSecondary: Color,
    val textOnPrimary: Color,

    val iconPrimary: Color,
    val iconSecondary: Color,
    val iconOnPrimary: Color,

    val primaryBrand: Color,
    val primaryBrandOpacity: Color,

    val strokeActive: Color,
    val stroke: Color,
    val strokeOnDarkSurface: Color,

    val error: Color,
    val errorLight: Color,
    val success: Color,
    val actionConfirmed: Color,
    val waiting: Color,
    val offline: Color,

    val primaryActive: Color,
    val primaryUnactive: Color,
    val controlOnPrimary: Color,
)

internal val defaultColors = AppColors(
    backgroundBlack = Color(0xFF1B1B1E),
    surfacePrimary = Color(0xFFFFFFFF),
    surfaceSecondary = Color(0xFFF1F1F1),
    surfaceOnBlackBg = Color(0xFF232529),
    surfaceOpacityWhite = Color(0x7FFFFFFF),
    surfaceOpacityBlack = Color(0x59000000),

    textPrimary = Color(0xFF000000),
    textSecondary = Color(0xFF8C8C8C),
    textOnPrimary = Color(0xFFFFFFFF),

    iconPrimary = Color(0xFF000000),
    iconSecondary = Color(0xFFC1C1C1),
    iconOnPrimary = Color(0xFFFFFFFF),

    primaryBrand = Color(0xFF6979F8),
    primaryBrandOpacity = Color(0xFF6979F8),

    strokeActive = Color(0xFF000000),
    stroke = Color(0xFFF2F2F2),
    strokeOnDarkSurface = Color(0xFF37393D),

    error = Color(0xFFDA1F24),
    errorLight = Color(0xFFFFE1E3),
    success = Color(0xFF459D68),
    actionConfirmed = Color(0xFF232529),
    waiting = Color(0xFFFE761C),
    offline = Color(0xFFB1B1B1),

    primaryActive = Color(0xFF000000),
    primaryUnactive = Color(0xFFEBEBEB),
    controlOnPrimary = Color(0xFFFFFFFF),
)
