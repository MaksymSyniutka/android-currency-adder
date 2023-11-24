import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.ExtensionContainer
import org.gradle.kotlin.dsl.getByType

@Suppress("UnstableApiUsage")
val Project.projectLibs: VersionCatalog
    get() = extensions.projectLibs

val ExtensionContainer.projectLibs: VersionCatalog
    get() = getByType<VersionCatalogsExtension>().named("libs")

@Suppress("UnstableApiUsage")
fun VersionCatalog.versionInt(name: String) = findVersion(name).get().requiredVersion.toInt()

@Suppress("UnstableApiUsage")
fun VersionCatalog.versionString(name: String) = findVersion(name).get().requiredVersion

fun VersionCatalog.pluginId(name: String) = findPlugin(name).get().get().pluginId