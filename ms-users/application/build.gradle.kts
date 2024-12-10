plugins {
    id("java-conventions")
}

group = "jva.cloud"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":ms-users:domain"))
    implementation("io.projectreactor:reactor-core:3.7.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}