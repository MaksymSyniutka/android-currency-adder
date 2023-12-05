plugins {
    id(libs.plugins.common.android.application.module)
    alias(libs.plugins.detekt)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktlint)
}

android {
    compileSdk = 34
    namespace = "eu.krzdabrowski.currencyadder"

    defaultConfig {
        applicationId = "eu.krzdabrowski.currencyadder"
        minSdk = 26
        targetSdk = 34
        versionCode = 5
        versionName = "1.2.2"
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
            // for development purposes, remember to create a release signing config if releasing app
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    kotlin {
        jvmToolchain(17)
    }

    packaging {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

hilt {
    enableAggregatingTask = true
}

dependencies {
    implementation(projects.core.database.android) // needed for DI
    implementation(projects.core.navigation) // needed for DI
    implementation(projects.core.network.data) // needed for DI
    implementation(projects.core.utils.kotlin.impl) // needed for DI

    implementation(projects.feature.exchangeRates.data) // needed for DI
    implementation(projects.feature.mainScreen.presentation) // needed for DI
    implementation(projects.feature.totalSavings.data) // needed for DI
    implementation(projects.feature.totalSavings.presentation) // needed for DI
    implementation(projects.feature.userSavings.data) // needed for DI
    implementation(projects.feature.userSavings.presentation) // needed for DI

    implementation(libs.hilt)
    implementation(libs.timber)

    ksp(libs.hilt.compiler)
}