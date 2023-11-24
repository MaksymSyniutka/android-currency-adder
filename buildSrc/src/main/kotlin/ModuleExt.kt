import org.gradle.api.provider.Provider
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependency
import org.gradle.plugin.use.PluginDependencySpec

@Suppress("UnstableApiUsage")
fun PluginDependenciesSpec.id(provider: Provider<PluginDependency>): PluginDependencySpec {
    return id(provider.get().pluginId)
}