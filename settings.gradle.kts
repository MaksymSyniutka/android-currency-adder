@file:Suppress("UnstableApiUsage")

includeBuild("buildSrcIncluded")

include(":app")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

// region submodules
includeRecursive(dir = file("feature"), dirModuleName = ":feature")
includeRecursive(dir = file("core"), dirModuleName = ":core")

fun includeRecursive(dir: File, dirModuleName: String) {
    if (dir.isModule()) {
        include(dirModuleName)
        project(dirModuleName).projectDir = dir
    } else {
        dir.listFiles()
            ?.filter { it.isDirectory }
            ?.forEach { subDir ->
                includeRecursive(
                    dir = subDir,
                    dirModuleName = "$dirModuleName:${subDir.name}",
                )
            }
    }
}

fun File.isModule(): Boolean {
    return fileExists("build.gradle") || fileExists("build.gradle.kts")
}

fun File.fileExists(path: String): Boolean {
    return File(this, path).isFile
}
// endregion


pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal() // hint: https://developer.android.com/build/optimize-your-build#gradle_plugin_portal
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

buildCache {
    local {
        isEnabled = true
        directory = File(rootDir, "build-cache")
        removeUnusedEntriesAfterDays = 14
    }
}
