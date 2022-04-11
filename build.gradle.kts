buildscript {

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.20")
        classpath("com.android.tools.build:gradle:7.3.0-alpha07")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://repo.maven.apache.org/maven2")
        maven("https://repo1.maven.org/maven2/")
        maven("https://dl.bintray.com/icerockdev/moko")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}