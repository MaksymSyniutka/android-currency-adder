plugins {
    id(libs.plugins.common.android.library.module)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.addcurrency.impl"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    implementation(projects.core.architecture.android)
    implementation(projects.core.navigation.android)
    implementation(projects.core.utils.android)

    implementation(projects.feature.totalSavings.impl)
    implementation(projects.feature.userSavings.impl)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.material3)
    implementation(libs.hilt)
    implementation(libs.kotlin.coroutines)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.timber)
    implementation(libs.navigation)
    implementation(libs.navigation.hilt)
    testImplementation(libs.bundles.common.test)
    androidTestImplementation(libs.bundles.common.android.test)
    androidTestImplementation(libs.datastore) // needed for Hilt tests
    debugImplementation(libs.debug.compose.manifest)

    ksp(libs.hilt.compiler)
    kspAndroidTest(libs.test.android.hilt.compiler)

    detektPlugins(libs.detekt.compose.rules)

    androidTestImplementation(testFixtures(projects.feature.exchangeRates.api))
    androidTestImplementation(testFixtures(projects.feature.exchangeRates.impl)) // needed for DI modules
    androidTestImplementation(testFixtures(projects.feature.totalSavings.api))
    androidTestImplementation(testFixtures(projects.feature.totalSavings.impl)) // needed for DI modules
    androidTestImplementation(testFixtures(projects.feature.userSavings.api))
    androidTestImplementation(testFixtures(projects.feature.userSavings.impl)) // needed for DI modules
    androidTestImplementation(projects.core.utils.test.android)
}