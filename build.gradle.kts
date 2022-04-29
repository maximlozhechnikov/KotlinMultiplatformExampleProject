buildscript {

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven ("https://maven.google.com")
        maven("https://kotlin.bintray.com/kotlinx")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.20")
        classpath("com.android.tools.build:gradle:7.1.2")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://repo.maven.apache.org/maven2")
        maven("https://repo1.maven.org/maven2/")
        maven("https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}