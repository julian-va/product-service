plugins {
    id("java-conventions")
}

group = "jva.cloud"
version = "0.0.1-SNAPSHOT"


dependencies {
    implementation(project(":ms-products:domain"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    testImplementation(kotlin("test"))
}