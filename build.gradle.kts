plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("org.sonarqube") version "3.3"
}
sonarqube {
    properties {
        property("sonar.projectKey", "BdMobileApp")  // Ganti dengan project key di SonarQube
        property("sonar.host.url", "http://localhost:9000")  // URL instance SonarQube-mu
        property("sonar.login", "sqa_4588754e1f28fa702c46cbaf2500455a8d5502ab")  // Token SonarQube yang kamu buat
    }
}