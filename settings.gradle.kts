pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://repo.maven.apache.org/maven2")
        maven("https://repo1.maven.org/maven2/")
        maven("https://dl.bintray.com/icerockdev/moko")
    }
}

rootProject.name = "ExampleProject"
include(":androidApp")
include(":shared")