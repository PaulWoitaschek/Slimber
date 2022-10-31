plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "slimber"
    compileSdk = 33

    defaultConfig {
        minSdk = 15
    }
    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    api("com.jakewharton.timber:timber:5.0.1")
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation("junit:junit:4.13.2")
}
