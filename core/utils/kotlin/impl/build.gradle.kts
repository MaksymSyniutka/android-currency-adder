plugins {
    id(libs.plugins.common.android.library.module)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.core.utils.kotlin.impl"
}

dependencies {
    implementation(projects.core.common.entities.di)

    implementation(libs.kotlin.coroutines)
    implementation(libs.timber)

    implementation(libs.hilt)
    ksp(libs.hilt.compiler)
}