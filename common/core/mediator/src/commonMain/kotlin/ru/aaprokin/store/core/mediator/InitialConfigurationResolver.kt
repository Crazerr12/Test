package ru.aaprokin.store.core.mediator

class InitialConfigurationResolver(
//    private val tokenStorage: TokenStorage
) {
    fun resolve(): RootComponent.Config {
//        return if (tokenStorage.loadTokens() != null) {
//            RootComponent.Config.ProjectBrowserStory
//        } else {
//            RootComponent.Config.SignInStory
//        }

        return RootComponent.Config.AuthStory
    }
}