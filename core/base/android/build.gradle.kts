plugins {
    id(libs.plugins.common.android.library.module)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.core.base.android"
}

dependencies {
    implementation(projects.core.utils.kotlin)

    implementation(libs.kotlin.coroutines)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.viewmodel.savedstate)
    implementation(libs.timber)
}