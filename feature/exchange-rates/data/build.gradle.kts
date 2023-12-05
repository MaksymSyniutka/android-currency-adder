plugins {
    id(libs.plugins.common.android.library.module)
    alias(libs.plugins.junit)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.exchangerates.data"
}

dependencies {
    implementation(projects.feature.exchangeRates.domain)
    implementation(projects.core.database.kotlin)
    implementation(projects.core.utils.android)

    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    implementation(libs.kotlin.coroutines)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.kotlin.serialization)
    implementation(libs.retrofit)
    implementation(libs.timber)
    testImplementation(libs.bundles.common.test)
    androidTestImplementation(libs.bundles.common.android.test)
    androidTestImplementation(libs.datastore) // needed for Hilt tests
    debugImplementation(libs.debug.compose.manifest)
}