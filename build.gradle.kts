plugins {
    java
    alias(libs.plugins.gitSemVer)
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(rootProject.libs.junit.api)
    testRuntimeOnly(rootProject.libs.junit.engine)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}