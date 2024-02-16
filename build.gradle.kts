plugins {
    java
    application
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

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.anastasiakassari.rps.app.RockPaperScissorsApp"
    }
}