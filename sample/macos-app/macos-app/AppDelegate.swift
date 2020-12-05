//
//  AppDelegate.swift
//  macos-app
//
//  Created by Nagy Robert on 05/12/2020.
//

import Cocoa
import SwiftUI
import MultiPlatformLibrary

@NSApplicationMain
class AppDelegate: NSObject, NSApplicationDelegate {
    
    var window: NSWindow!
    private let graphicsTest = GraphicsTest()
    
    func applicationDidFinishLaunching(_ aNotification: Notification) {
        // Create the SwiftUI view that provides the window contents.
        let contentView = ContentView()
        
        // Create the window and set the content view.
        window = NSWindow(
            contentRect: NSRect(x: 0, y: 0, width: 480, height: 300),
            styleMask: [.titled, .closable, .miniaturizable, .resizable, .fullSizeContentView],
            backing: .buffered, defer: false)
        window.isReleasedWhenClosed = false
        window.center()
        window.setFrameAutosaveName("Main Window")
        window.contentView = NSHostingView(rootView: contentView)
        window.makeKeyAndOrderFront(nil)
        window.backgroundColor = graphicsTest.backgroundColor.toNSColor()
    }
    
    func applicationWillTerminate(_ aNotification: Notification) {
        // Insert code here to tear down your application
    }
}

extension GraphicsColor {
    func toNSColor() -> NSColor{
        let maxColorValue = CGFloat(0xFF)
        return NSColor(red: CGFloat(red) / maxColorValue, green: CGFloat(green) / maxColorValue, blue: CGFloat(blue) / maxColorValue, alpha: CGFloat(alpha) / maxColorValue)
    }
}

