plugins {
    id(libs.plugins.common.android.library.module)
    alias(libs.plugins.detekt)
    alias(libs.plugins.junit)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.ksp)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.usersavings.presentation"

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
    implementation(projects.core.navigation.android)
    implementation(projects.core.utils.android)
    implementation(projects.core.utils.compose)

    implementation(projects.feature.exchangeRates.domain)
    implementation(projects.feature.totalSavings.domain)
    implementation(projects.feature.userSavings.domain)

    implementation(libs.accompanist.swipe.refresh)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.material3)
    implementation(libs.hilt)
    implementation(libs.kotlin.coroutines)
    implementation(libs.kotlin.datetime)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.timber)
    testImplementation(libs.bundles.common.test)
    androidTestImplementation(libs.bundles.common.android.test)
    androidTestImplementation(libs.datastore) // needed for Hilt tests
    debugImplementation(libs.debug.compose.manifest)

    ksp(libs.hilt.compiler)
    kspAndroidTest(libs.test.android.hilt.compiler)

    detektPlugins(libs.detekt.compose.rules)
}
