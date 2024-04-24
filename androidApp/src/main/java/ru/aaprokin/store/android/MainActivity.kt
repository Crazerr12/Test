package ru.aaprokin.store.android

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.content.res.ResourcesCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.arkivanov.decompose.defaultComponentContext
import org.koin.android.ext.android.inject
import ru.aaprokin.store.core.mediator.RootComponent
import ru.aaprokin.store.core.mediator.RootCoordinator

class MainActivity : ComponentActivity() {
    private val rootComponentFactory: RootComponent.Factory by inject()

    private val shouldSplashScreenDismiss: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupWindow()
        setupRootComponent()
    }

    /**
     * Переводим наше приложение в "полноэкранный режим", когда наш контент располагается под
     * системными барами и его расположением мы управляем с помощью WindowInsets
     *
     * Устанавливаем сплэш из Splash API
     */
    private fun setupWindow() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
    }

    /**
     * Создается корневой компонент приложения, устанавливается глобальная тема Compose и задается
     * стартовая точка входа в экраны приложения.
     *
     * Именно в [RootComponent] определяется, перейдем ли мы при старте на экран авторизации или
     * же на стартовые экраны авторизованного пользователя.
     *
     * Стоит отметить, что [RootCoordinator] сам по себе не является экраном, а, как и все *Container,
     * лишь управляет навигацией внутри своего подграфа. В данном случае основного подграфа всего
     * приложения.
     *
     * Глобальная тема Compose позволяет нам в будущем для всех вложенных реализаций @Composable
     * использовать кастомные атрибуты, такие как смещения или цвета. Так же в рамках глобальной
     * темы происходит первоначальная настройка таких параметров, как цвет системного и
     * навигационного бара. Подробнее: [AppTheme]
     */
    private fun setupRootComponent() {
        val rootComponent = rootComponentFactory.create(
            componentContext = defaultComponentContext()
        )
        setContent {
//            AppTheme {
                RootCoordinator(rootComponent = rootComponent)
//            }
        }
        keepSplashScreenUntilAllComplete()
    }

    /**
     * Splash API закроет сплэш если приложение нарисует первый фрейм.
     *
     * Поэтому мы приостанавливаем отмену сплэша до того момента, пока не будет загружен граф
     * зависимостей. Подробнее: [shouldSplashScreenDismiss]
     *
     * Так же производится ручная установка темы для API < 31.
     * Подробнее: [manualApplyPostSplashScreenThemeForOlderApis]
     */
    private fun keepSplashScreenUntilAllComplete() {
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener {
            if (shouldSplashScreenDismiss) {
                manualApplyPostSplashScreenThemeForOlderApis()
                true
            } else {
                false
            }
        }
    }

    /**
     * Вручную делаем то, что Splash API делает автоматически с помощью атрибута
     * postSplashScreenTheme темы
     */
    private fun manualApplyPostSplashScreenThemeForOlderApis() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            window.setBackgroundDrawableResource(R.color.window_background)
            window.statusBarColor =
                ResourcesCompat.getColor(resources,
                    R.color.status_bar_color, null)
            window.navigationBarColor =
                ResourcesCompat.getColor(resources,
                    R.color.navigation_bar_color, null)
            WindowInsetsControllerCompat(window, window.decorView).apply {
                isAppearanceLightStatusBars = true
                isAppearanceLightNavigationBars = true
            }
        }
    }
}
