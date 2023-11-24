plugins {
    id(libs.plugins.common.android.library.module)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.junit)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.core.navigation.android"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    implementation(projects.core.common.entities.di)

    implementation(platform(libs.compose.bom))
    implementation(libs.navigation)
    implementation(libs.timber)

    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    testImplementation(libs.bundles.common.test)
}