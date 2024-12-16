plugins {
    java
    id("org.jetbrains.kotlin.jvm")
    id("io.freefair.lombok") // Note: version is NOT specified here. See Step 7
    // add any other Gradle plugins here
    // id("org.jetbrains.kotlin.kapt")
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

dependencies {
    // add any dependencies that you want to apply to all your monorepo projects here
    implementation("org.mapstruct:mapstruct:1.6.2")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}


tasks.withType<Test> {
    useJUnitPlatform()
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}