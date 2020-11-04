plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.2"
    defaultConfig {
        applicationId = "com.g00fy2.androidjavatimedemo"
        minSdkVersion(19)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".threeten"
        }
        getByName("release") {
            applicationIdSuffix = ".threeten"
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        viewBinding = true
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }
    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

repositories {
    google()
    mavenCentral()
    jcenter {
        content {
            includeModule("org.jetbrains.trove4j", "trove4j") // required by com.android.tools.lint:lint-gradle
        }
    }
}

dependencies {
    implementation("com.jakewharton.threetenabp:threetenabp:1.3.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
}