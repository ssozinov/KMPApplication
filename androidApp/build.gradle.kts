plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)

}

android {
    namespace = "com.test.kmpapplication.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.test.kmpapplication.android"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
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
    implementation(projects.shared)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.activity.compose)
    /**
     * Koin
     */
    implementation(libs.koin.core)
    implementation(libs.koin.androidx.compose)
}