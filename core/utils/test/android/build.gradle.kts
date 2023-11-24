plugins {
    id(libs.plugins.common.android.library.module)
    alias(libs.plugins.hilt)
    alias(libs.plugins.junit)
    alias(libs.plugins.ksp)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.core.utils.test.android"

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    implementation(platform(libs.compose.bom))

    implementation(libs.activity.ktx)
    implementation(libs.hilt)
    implementation(libs.bundles.common.test)
    implementation(libs.bundles.common.android.test)

    ksp(libs.hilt.compiler)
}