buildscript {

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        mavenLocal()
        maven ("https://maven.google.com")
        maven("https://kotlin.bintray.com/kotlinx")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.20")
        classpath("com.android.tools.build:gradle:7.0.4")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven("https://repo.maven.apache.org/maven2")
        maven("https://repo1.maven.org/maven2/")
        maven("https://jitpack.io")
    }
}

subprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf(
                "-XXLanguage:+KotlinFunInterfaceConstructorReference",
                "-XXLanguage:+Xcontext-receivers"
            )
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}