plugins {
    id(libs.plugins.common.android.library.module)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.core.architecture.android"
}

dependencies {
    implementation(projects.core.utils.kotlin.api)

    implementation(libs.kotlin.coroutines)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.viewmodel.savedstate)
    implementation(libs.timber)
}