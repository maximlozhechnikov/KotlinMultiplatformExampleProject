pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://repo.maven.apache.org/maven2")
        maven("https://repo1.maven.org/maven2/")
        maven("https://jitpack.io")
        maven("https://kotlin.bintray.com/kotlinx")
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "kotlinx-serialization"->{
                    useModule("org.jetbrains.kotlinx:kotlinx-gradle-serialization-plugin:${requested.version}")
                }
            }
        }
    }
}

rootProject.name = "ExampleProject"
include(":androidApp")
include(":shared")