![moko-graphics](img/logo.png)  
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0) [![Download](https://img.shields.io/maven-central/v/dev.icerock.moko/moko-graphics) ](https://repo1.maven.org/maven2/dev/icerock/moko/moko-graphics) ![kotlin-version](https://img.shields.io/badge/kotlin-1.4.31-orange)

# Mobile Kotlin graphics
This is a Kotlin Multiplatform library that provides graphics primitives to common code.  

## Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Versions](#versions)
- [Installation](#installation)
- [Usage](#usage)
- [Samples](#samples)
- [Set Up Locally](#set-up-locally)
- [Contributing](#contributing)
- [License](#license)

## Features
- **Color** converting according to the platform-side requirements (argb/rgba);
- All Kotlin Multiplatform targets support.

## Requirements
- Gradle version 6.0+
- Android API 16+
- iOS version 9.0+

## Versions
### Bintray
- kotlin 1.3.50
  - 0.1.0
- kotlin 1.3.60
  - 0.2.0
- kotlin 1.3.70
  - 0.3.0
- kotlin 1.4.0
  - 0.4.0
- kotlin 1.4.20
  - 0.5.0
- kotlin 1.4.21
  - 0.6.0
### mavenCentral
- kotlin 1.4.31
  - 0.6.1

## Installation
root build.gradle  
```groovy
allprojects {
    repositories {
      mavenCentral()
    }
}
```

project build.gradle
```groovy
dependencies {
    commonMainApi("dev.icerock.moko:graphics:0.6.1")
}
```

## Usage
### Color
```kotlin
val red = Color(
    red = 0xFF,
    green = 0x00,
    blue = 0x00,
    alpha = 0xFF
)

val rgba: Long = red.rgba
val argb: Long = red.argb // android compatible
```

## Samples
Please see more examples in the [sample directory](sample).

## Set Up Locally 
- The [graphics directory](graphics) contains the `graphics` library;
- The [sample directory](sample) contains sample apps for Android and iOS; plus the mpp-library connected to the apps;

## Contributing
All development (both new features and bug fixes) is performed in the `develop` branch. This way `master` always contains the sources of the most recently released version. Please send PRs with bug fixes to the `develop` branch. Documentation fixes in the markdown files are an exception to this rule. They are updated directly in `master`.

The `develop` branch is pushed to `master` on release.

For more details on contributing please see the [contributing guide](CONTRIBUTING.md).

## License
        
    Copyright 2019 IceRock MAG Inc.
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.