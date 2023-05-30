pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

}
rootProject.name = "CV"
include("data")
include("presentation")


object Dependencies
{
    object Versions
    {
        const val dagger = "2.45"
        const val gson = "2.10.1"
        const val koin = "3.2.0"
        const val librePdf = "1.3.30"
        const val jupiter = "5.9.2"
    }

    object Dagger
    {
        const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    }

    object Koin
    {
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val test = "io.insert-koin:koin-test:${Versions.koin}"
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
    }

    object LibrePdf
    {
        const val openPdf = "com.github.librepdf:openpdf:${Versions.librePdf}"
    }

    object Jupiter
    {
        const val api = "org.junit.jupiter:junit-jupiter-api:${Versions.jupiter}"
        const val engine = "org.junit.jupiter:junit-jupiter-engine:${Versions.jupiter}"
    }

    object Json
    {
        const val gson = "com.google.code.gson:gson:${Versions.gson}"
    }
}

(gradle as ExtensionAware).apply {
    extra["openPdf"] = Dependencies.LibrePdf.openPdf
    extra["dagger"] = Dependencies.Dagger.dagger
    extra["daggerCompiler"] = Dependencies.Dagger.compiler
    extra["gson"] = Dependencies.Json.gson
    extra["koinCore"] = Dependencies.Koin.core
    extra["jupiterApi"] = Dependencies.Jupiter.api
    extra["jupiterEngine"] = Dependencies.Jupiter.engine
}
