plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("com.anastasiakassari.rps.app.RockPaperScissorsApp")
}

dependencies {
    implementation("org.slf4j:slf4j-api:2.0.11")
    implementation("ch.qos.logback:logback-classic:1.4.14")
    implementation("javax.validation:validation-api:2.0.1.Final")
}

tasks.shadowJar {
    archiveBaseName.set(rootProject.name)
    archiveClassifier.set("shadow")
}