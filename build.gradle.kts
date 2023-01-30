plugins {
    java
    application
    alias(libs.plugins.gitSemVer)
    alias(libs.plugins.javafx)
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

// List of JavaFX modules you need. Comment out things you are not using.
val javaFXModules = listOf(
        "base",
        "controls",
        "fxml",
        "swing",
        "graphics"
)
// All required for OOP
val supportedPlatforms = listOf("linux", "mac", "win")

dependencies {
    implementation(libs.bundles.vertx.dependencies)
    implementation(libs.gson)
    // JavaFX: comment out if you do not need them
    for (platform in supportedPlatforms) {
        for (module in javaFXModules) {
            implementation("org.openjfx:javafx-$module:19:$platform")
        }
    }
    //testImplementation(libs.awaitility)
    testImplementation(libs.bundles.testfx)
    testImplementation(libs.junit.api)
    testRuntimeOnly(libs.junit.engine)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}