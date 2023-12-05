plugins {
    id(libs.plugins.common.android.library.module)
    alias(libs.plugins.detekt)
    alias(libs.plugins.junit)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.ksp)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.totalsavings.presentation"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}
dependencies {
    implementation(projects.core.architecture.android)
    implementation(projects.core.database.kotlin)
    implementation(projects.core.utils.android)

    implementation(projects.feature.exchangeRates.domain)
    implementation(projects.feature.totalSavings.domain)
    implementation(projects.feature.userSavings.domain)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.material3)
    implementation(libs.hilt)
    implementation(libs.kotlin.coroutines)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.timber)
    testImplementation(libs.bundles.common.test)
    androidTestImplementation(libs.bundles.common.android.test)
    androidTestImplementation(libs.datastore) // needed for Hilt tests
    debugImplementation(libs.debug.compose.manifest)

    ksp(libs.hilt.compiler)
    kspAndroidTest(libs.test.android.hilt.compiler)

    detektPlugins(libs.detekt.compose.rules)

    androidTestImplementation(testFixtures(projects.feature.exchangeRates.domain))
    androidTestImplementation(testFixtures(projects.feature.totalSavings.domain))
    androidTestImplementation(projects.core.utils.test.android)
}
