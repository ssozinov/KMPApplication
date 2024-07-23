plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    id("com.google.devtools.ksp") version "2.0.0-1.0.22"
    id("de.jensklingenberg.ktorfit") version "2.0.0"
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrainsCompose)

}

configure<de.jensklingenberg.ktorfit.gradle.KtorfitGradleConfiguration>{
    version = libs.versions.ktorfitVersion
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
        pod("Reachability") {
            version = "3.2"
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            implementation(libs.ktorfit.lib)
            implementation(libs.ktorfit.module)
            implementation(libs.ktorfit.converters.call)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.ktorfit.converters.flow)
            implementation(libs.ktor.client.serialization)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)

            /**
             * Voyager
             */
            implementation(libs.voyager.navigator)
            implementation(libs.voyager.bottomSheetNavigator)
            implementation(libs.voyager.tabNavigator)

            /**
             * Compose
             */
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.test.kmpapplication"
    compileSdk = 34
    defaultConfig {
        minSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
dependencies {
    implementation(libs.androidx.foundation.android)
    implementation(libs.androidx.runtime.android)
    val ktorfitVersion = libs.versions.ktorfitVersion
    add("kspCommonMainMetadata", "de.jensklingenberg.ktorfit:ktorfit-ksp:$ktorfitVersion")
    add("kspAndroid", "de.jensklingenberg.ktorfit:ktorfit-ksp:$ktorfitVersion")
    add("kspIosX64", "de.jensklingenberg.ktorfit:ktorfit-ksp:$ktorfitVersion")
    add("kspIosArm64", "de.jensklingenberg.ktorfit:ktorfit-ksp:$ktorfitVersion")
    add("kspIosSimulatorArm64", "de.jensklingenberg.ktorfit:ktorfit-ksp:$ktorfitVersion")
}
