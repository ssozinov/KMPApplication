enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "KMPApplication"
include(":androidApp")
include(":shared")
include (":common:trainers:api")
include (":common:trainers:presentation")
include (":common:trainers:data")

include (":common:lessons")
include (":common:tabs")