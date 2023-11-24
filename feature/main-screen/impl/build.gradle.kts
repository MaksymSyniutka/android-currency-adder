plugins {
    id(libs.plugins.common.android.library.module)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.feature.mainscreen.impl"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    implementation(projects.core.navigation.android)
    implementation(projects.core.compose.theme)
    implementation(projects.core.utils.android)
    implementation(projects.core.utils.compose)

    implementation(projects.feature.addCurrency.impl) // needed for DI

    implementation(platform(libs.compose.bom))
    implementation(libs.biometric)
    implementation(libs.compose.material3)
    implementation(libs.hilt)
    implementation(libs.kotlin.coroutines)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.navigation)
    implementation(libs.timber)
    androidTestImplementation(libs.bundles.common.android.test)

    ksp(libs.hilt.compiler)
    kspAndroidTest(libs.test.android.hilt.compiler)

    detektPlugins(libs.detekt.compose.rules)
}