plugins {
    id(libs.plugins.common.android.library.module)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.core.network.impl"

    defaultConfig {
        buildConfigField("String", "NBP_API_URL", "\"https://api.nbp.pl/api/\"")
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.hilt)
    implementation(libs.kotlin.coroutines)
    implementation(libs.kotlin.datetime)
    implementation(libs.kotlin.serialization)
    implementation(libs.kotlin.serialization.converter)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.retrofit)
    implementation(libs.timber)

    ksp(libs.hilt.compiler)
}