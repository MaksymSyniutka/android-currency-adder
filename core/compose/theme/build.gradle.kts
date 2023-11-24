plugins {
    id(libs.plugins.common.android.library.module)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.core.compose.theme"

    buildFeatures {
        buildConfig = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    implementation(platform(libs.compose.bom))

    implementation(libs.compose.material3)
    implementation(libs.core.ktx)
}