import AppConfig.applicationId
import Modules.appDependencies

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("kotlin-parcelize")
}

android {
        namespace = "co.tractionapps.weatherapp"

    compileSdk = AppConfig.compileSdk
    buildToolsVersion =AppConfig.buildToolsVersion

    defaultConfig {
        applicationId = AppConfig.applicationId //"co.tractionapps.weatherapp"
        minSdkVersion (AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }


    viewBinding {
        android.buildFeatures.viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}


dependencies {
    appDependencies()
}
