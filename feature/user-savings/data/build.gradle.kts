plugins {
    id(libs.plugins.common.android.library.module)
    alias(libs.plugins.junit)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.ksp)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.usersavings.data"
}

dependencies {
    implementation(projects.reusable.userSavings.domain)
    implementation(projects.core.database.kotlin)
    implementation(projects.core.utils.android)

    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    implementation(libs.kotlin.coroutines)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.timber)
    testImplementation(libs.bundles.common.test)
    androidTestImplementation(libs.bundles.common.android.test)
    androidTestImplementation(libs.datastore) // needed for Hilt tests
    debugImplementation(libs.debug.compose.manifest)
}