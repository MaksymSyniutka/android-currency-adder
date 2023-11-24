plugins {
    id(libs.plugins.common.kotlin.library.module)
}

dependencies {
    implementation(libs.kotlin.coroutines)
    implementation(libs.room.common)
}