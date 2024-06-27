plugins {
    id("com.android.application") version "8.4.1"
    id("org.jetbrains.kotlin.android") version "1.9.0"
    id("com.google.gms.google-services") version "4.4.2"
    id("org.sonarqube") version "3.3"
}


// SonarQube configuration
configure<org.sonarqube.gradle.SonarQubeExtension> {
    properties {
        property("sonar.host.url", "http://43.205.138.85:9000")
        property("sonar.login", System.getenv("sonarqube") ?: "")
    }
}
