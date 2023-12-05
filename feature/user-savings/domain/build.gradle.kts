plugins {
    id(libs.plugins.common.kotlin.library.module)
    id(libs.plugins.java.test.fixtures)
}

dependencies {
    implementation(libs.kotlin.coroutines)
}