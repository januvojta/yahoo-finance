import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktor_version = "2.0.0"
val coroutine_version = "1.6.1"
val assertj_version = "3.22.0"
val mock_version = "1.12.3"
val serialization_version = "1.3.2"
val datetime_version = "0.3.2"

plugins {
    kotlin("jvm") version "1.6.20"
    kotlin("plugin.serialization") version "1.6.20"
    application
}

group = "me.farmen"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:$assertj_version")
    testImplementation("io.mockk:mockk:$mock_version")
    testImplementation("io.ktor:ktor-client-mock:$ktor_version")

    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutine_version")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serialization_version")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:$datetime_version")
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