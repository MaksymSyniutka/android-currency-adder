plugins {
    id(libs.plugins.common.android.library.module)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "eu.krzdabrowski.currencyadder.core.database.android"
}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}

dependencies {
    implementation(projects.core.database.kotlin)

    implementation(libs.kotlin.coroutines)
    implementation(libs.datastore)
    implementation(libs.room.ktx)
    implementation(libs.room)

    implementation(libs.hilt)
    ksp(libs.hilt.compiler)
    ksp(libs.room.compiler)
}