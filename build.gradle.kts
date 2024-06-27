plugins {
    id("org.sonarqube") version "3.3"
    id("com.android.application") version "8.4.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
}


// SonarQube configuration
configure<org.sonarqube.gradle.SonarQubeExtension> {
    properties {
        property("sonar.host.url", "http://43.205.138.85:9000")
        property("sonar.login", System.getenv("sonarqube") ?: "")
    }
}
