# `Arc-Template`
`Arc-Template` is a template repository for creating games using the [Arc](https://github.com/Anuken/Arc) framework. The project structure is modular, initially with `:core` as common resource, and `:desktop` as desktop runtime implementation.

## General Structure
The project is divided into 2 modules:
- `:core`: This should contain resources that's shared to other runtime implementations. Initially, it has:
  - The `Template` class (`tmp/Template`), which is the main [`ApplicationCore`](https://github.com/Anuken/Arc/blob/v139/arc-core/src/arc/ApplicationCore.java) that's to be supplied with other application modules.
  - The `Logic` class (`tmp/core/Logic`), which is an [`ApplicationListener`](https://github.com/Anuken/Arc/blob/v139/arc-core/src/arc/ApplicationListener.java) that initially updates [`Time`](https://github.com/Anuken/Arc/blob/v139/arc-core/src/arc/util/Time.java).
  - The `Renderer` class (`tmp/core/Renderer`), which is an [`ApplicationListener`](https://github.com/Anuken/Arc/blob/v139/arc-core/src/arc/ApplicationListener.java) that initially handles a very basic example of rendering.
- `:desktop`: The desktop launcher for the game. Initially, it has:
  - The `DesktopApp` class (`tmp/desktop/DesktopApp`), which holds the entry point that instantiates an [`SdlApplication`](https://github.com/Anuken/Arc/blob/v139/backends/backend-sdl/src/arc/backend/sdl/SdlApplication.java) with `Template` as the main listener. Any errors caught while running will be logged into standard output and popped up in an error window.

## Requirements
- [JDK 17](https://adoptium.net/temurin/releases/) or higher.
- A fair knowledge of the Java programming language and the Arc framework.

## Using this Template
1. Click that big green `Use this template` button to copy this template as your repository.
2. Refactor. Point of interests:
    - [`appName` variable in `gradle.properties`](https://github.com/GlennFolker/Arc-Template/blob/master/gradle.properties#L2).
    - [The window title in `DesktopApp`](https://github.com/GlennFolker/Arc-Template/blob/master/desktop/src/tmp/desktop/DesktopApp.java#L14).
    - [The license's year and licensee](https://github.com/GlennFolker/Arc-Template/blob/master/LICENSE#L3).
    - [Artifact name in the GitHub CI](https://github.com/GlennFolker/Arc-Template/blob/master/.github/workflows/push.yml#L22-L23).
    - Other non-specific ones.
3. Compile and test (currently only desktop testing is available):
    - Run `gradlew desktop:run` to run the application.
    - Run `gradlew core:pack` to re-pack sprites. This task is automatically run if the `core/assets/sprites/` folder isn't available (which it is initially when you clone the template).
    - Run `gradlew desktop:dist` to pack the entire game and assets into a JAR file, located in `desktop/build/libs/`.
