/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

import UIKit
import MultiPlatformLibrary

class TestViewController: UIViewController {
    
    private let graphicsTest = GraphicsTest()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        view.backgroundColor = graphicsTest.backgroundColor.toUIColor()
    }
}
