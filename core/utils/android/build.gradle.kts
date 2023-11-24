plugins {
    id(libs.plugins.common.android.library.module)
    alias(libs.plugins.hilt)
    alias(libs.plugins.junit)
    alias(libs.plugins.ksp)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.core.android.utils"
}

dependencies {
    implementation(platform(libs.compose.bom))
    implementation(libs.hilt)
    implementation(libs.kotlin.coroutines)
    implementation(libs.kotlin.datetime)
    androidTestImplementation(libs.bundles.common.android.test)

    ksp(libs.hilt.compiler)
}
