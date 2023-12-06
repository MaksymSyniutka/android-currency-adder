plugins {
    id(libs.plugins.common.android.library.module)
    alias(libs.plugins.junit)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.ksp)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.totalsavings.data"
}

dependencies {
    implementation(projects.core.database.kotlin)
    implementation(projects.core.utils.android)
    implementation(projects.reusable.totalSavings.domain)

    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    implementation(libs.kotlin.coroutines)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.timber)
    testImplementation(libs.bundles.common.test)
    debugImplementation(libs.debug.compose.manifest)
}