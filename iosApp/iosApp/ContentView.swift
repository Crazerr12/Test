//
//  ContentView.swift
//  iosApp
//
//  Created by Alexandr Prokin on 25.03.2024.
//

import SwiftUI
import StoreKit

struct ComposeView: UIViewControllerRepresentable {
        
    private var component : RootComponent
    
    init(component : RootComponent){
        self.component = component
    }
    
    func makeUIViewController(context: Context) -> UIViewController {
        HelplerKt.MainViewController(component : component)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    
    private var component : RootComponent
    
    init(component : RootComponent){
        self.component = component
    }
    
    var body: some View {
        ComposeView(component: component)
                .ignoresSafeArea()
    }
}


