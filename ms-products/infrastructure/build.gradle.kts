plugins {
    id("java-conventions")
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.3.5"
    id("io.spring.dependency-management") version "1.1.6"
    id("org.jetbrains.kotlin.kapt")
}

group = "jva.cloud"
version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(project(":ms-products:application"))
    implementation(project(":ms-products:domain"))
    implementation("io.opentelemetry.instrumentation:opentelemetry-spring-boot-starter")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    kapt("org.mapstruct:mapstruct-processor:1.6.2")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("org.postgresql:r2dbc-postgresql")
    implementation("org.springframework.kafka:spring-kafka")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.springframework.kafka:spring-kafka-test")
}

dependencyManagement {
    imports {
        mavenBom("io.opentelemetry.instrumentation:opentelemetry-instrumentation-bom:2.10.0")
    }
}