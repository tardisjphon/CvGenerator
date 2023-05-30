import org.jetbrains.kotlin.gradle.plugin.extraProperties

plugins {
    id("java")
    id("kotlin-kapt")
    kotlin("jvm") version "1.8.21"
    application
}

group = "js.cv.presentation"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":data"))

    implementation(getProperty("openPdf"))

    implementation(getProperty("dagger"))
    kapt(getProperty("daggerCompiler"))
    implementation(getProperty("koinCore"))

    testImplementation(getProperty("jupiterApi"))
    runtimeOnly(getProperty("jupiterEngine"))
}

fun getProperty(name: String): String
{
    return gradle.extraProperties.properties[name] as String
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}