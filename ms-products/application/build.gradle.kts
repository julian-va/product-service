plugins {
    id("java-conventions")
}

group = "jva.cloud"
version = "0.0.1-SNAPSHOT"


dependencies {
    implementation(project(":ms-products:domain"))
    testImplementation(kotlin("test"))
}