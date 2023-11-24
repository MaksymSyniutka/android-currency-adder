plugins {
    id(libs.plugins.common.android.library.module)
    alias(libs.plugins.junit)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.detekt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.usersavings.impl"

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
    implementation(projects.feature.userSavings.api)

    implementation(projects.feature.exchangeRates.api)
    implementation(projects.feature.totalSavings.api)
    implementation(projects.feature.userSavings.api)

    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    implementation(libs.accompanist.swipe.refresh)
    implementation(libs.compose.material3)
    implementation(libs.kotlin.coroutines)
    implementation(libs.kotlin.datetime)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.timber)
    implementation(platform(libs.compose.bom))

    testImplementation(libs.bundles.common.test)
    androidTestImplementation(libs.bundles.common.android.test)
    androidTestImplementation(libs.datastore) // needed for Hilt tests
    debugImplementation(libs.debug.compose.manifest)

    testFixturesImplementation(projects.feature.userSavings.api)

    testFixturesImplementation(testFixtures(projects.feature.exchangeRates.api))
    testFixturesImplementation(testFixtures(projects.feature.userSavings.api))
    testFixturesImplementation(libs.bundles.common.android.test)
    testFixturesImplementation(libs.hilt)

    kspTestFixtures(libs.hilt.compiler)
    kspTestFixtures(libs.test.android.hilt.compiler)
}