plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization") version("1.6.10")
    id("com.android.library")
}

version = "1.0"

kotlin {
    val ktor_version: String by project
    val coroutine_version: String by project
    val moko_mvvm_version: String by project
    val vk_sdk_version: String by project
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            version = "1.0"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib")
                implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.20")
                //KTor
                implementation("io.ktor:ktor-client-core:$ktor_version")
                implementation("io.ktor:ktor-client-json:$ktor_version")
                implementation("io.ktor:ktor-client-cio:$ktor_version")
                implementation("io.ktor:ktor-client-logging:$ktor_version")
                implementation("io.ktor:ktor-client-serialization:$ktor_version")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutine_version") {
                    isForce = true
                }

                //MVVM
                implementation("dev.icerock.moko:mvvm-core:$moko_mvvm_version")
                implementation("dev.icerock.moko:mvvm-livedata:$moko_mvvm_version")
                implementation("dev.icerock.moko:mvvm-state:$moko_mvvm_version")
                implementation("dev.icerock.moko:mvvm-livedata-resources:$moko_mvvm_version")

//                //vk-kmp_sdk
//                implementation("com.petersamokhin.vksdk:core:$vk_sdk_version")
//                implementation("com.petersamokhin.vksdk:http-client-common-ktor:$vk_sdk_version")

                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.2")
                implementation("com.omega:rocket.chat.kmm:0.0.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib")
                implementation("io.ktor:ktor-client-android:$ktor_version")
                implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                //KTor
                implementation("io.ktor:ktor-client-ios:$ktor_version")
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}


android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }
}