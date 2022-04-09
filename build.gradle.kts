import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktorVersion = "2.0.0"
val coroutineVersion = "1.6.1"
val assertjVersion = "3.22.0"

plugins {
    kotlin("jvm") version "1.6.20"
    application
}

group = "me.farmen"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:$assertjVersion")

    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}