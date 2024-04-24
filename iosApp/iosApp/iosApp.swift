//
//  iosAppApp.swift
//  iosApp
//
//  Created by Alexandr Prokin on 25.03.2024.
//
import SwiftUI
import StoreKit


@main
struct iOSApp: App {
    
    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate: AppDelegate

    @Environment(\.scenePhase)
    var scenePhase: ScenePhase

    var rootHolder: RootHolder { appDelegate.rootHolder }

    
    var body: some Scene {
        WindowGroup {
            ContentView(component: rootHolder.root)
                .onChange(of: scenePhase) { newPhase in
                    switch newPhase {
                    case .background: LifecycleRegistryExtKt.stop(rootHolder.lifecycle)
                    case .inactive: LifecycleRegistryExtKt.pause(rootHolder.lifecycle)
                    case .active: LifecycleRegistryExtKt.resume(rootHolder.lifecycle)
                    @unknown default: break
                    }
                }
        }
    }
}


class AppDelegate: NSObject, UIApplicationDelegate {
    let rootHolder: RootHolder = RootHolder()
}

class RootHolder : ObservableObject {
    let lifecycle: LifecycleRegistry
    let root: RootComponent

    init() {
        HelplerKt.doInitKoin()
        let iosRootComponent = IosRootComponent()
        
        lifecycle = LifecycleRegistryKt.LifecycleRegistry()
        
        root =  iosRootComponent.create(lifecycleRegistry: lifecycle)

        LifecycleRegistryExtKt.create(lifecycle)
    }

    deinit {
        // Destroy the root component before it is deallocated
        LifecycleRegistryExtKt.destroy(lifecycle)
    }
}
