plugins {
    id(libs.plugins.common.android.library.module)
    alias(libs.plugins.detekt)
    alias(libs.plugins.junit)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.ksp)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.usersavings.ui"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    testFixtures {
        enable = true
    }
}
dependencies {
    implementation(projects.core.architecture.android)
    implementation(projects.core.database.api)
    implementation(projects.core.navigation.android)
    implementation(projects.core.utils.android)
    implementation(projects.core.utils.compose)

    implementation(projects.feature.exchangeRates.api)
    implementation(projects.feature.totalSavings.api)
    implementation(projects.feature.userSavings.api)

    androidTestImplementation(testFixtures(projects.feature.userSavings.ui))
    androidTestImplementation(projects.core.utils.test.android)

    testFixturesImplementation(testFixtures(projects.feature.exchangeRates.api))

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
