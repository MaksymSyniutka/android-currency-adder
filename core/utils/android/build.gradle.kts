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
    implementation(projects.core.base.kotlin)

    implementation(platform(libs.compose.bom))
    implementation(libs.hilt)
    implementation(libs.kotlin.coroutines)
    implementation(libs.kotlin.datetime)
    implementation(libs.timber)

    ksp(libs.hilt.compiler)
}
