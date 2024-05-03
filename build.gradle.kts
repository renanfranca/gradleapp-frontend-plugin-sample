plugins {
  java
  alias(libs.plugins.sonarqube)
  checkstyle
  // jhipster-needle-gradle-plugins
}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

fun loadSonarProperties(): Map<String, List<String>> {
    val properties = mutableMapOf<String, List<String>>()
    File("sonar-project.properties").forEachLine { line ->
        if (!line.startsWith("#") && line.contains("=")) {
            val (key, value) = line.split("=", limit = 2)
            properties[key.trim()] = value.split(",").map { it.trim() }
        }
    }
    return properties
}

sonarqube {
    properties {
      loadSonarProperties().forEach { (key, value) ->
        property(key, value)
      }
      property("sonar.coverage.jacoco.xmlReportPaths", "build/reports/jacoco/test/jacocoTestReport.xml")
      property("sonar.junit.reportPaths", "build/test-results/test,build/test-results/integrationTest")
    }
}


checkstyle {
  configFile = rootProject.file("checkstyle.xml")
  toolVersion = libs.versions.checkstyle.get()
}

// jhipster-needle-gradle-plugins-configurations

repositories {
  mavenCentral()
  // jhipster-needle-gradle-repositories
}

group = "tech.jhipster.gradleapp"
version = "0.0.1-SNAPSHOT"

// jhipster-needle-gradle-properties

val profiles = (project.findProperty("profiles") as String? ?: "")
  .split(",")
  .map { it.trim() }
  .filter { it.isNotEmpty() }
// jhipster-needle-profile-activation

dependencies {
  // jhipster-needle-gradle-implementation-dependencies
  // jhipster-needle-gradle-compile-dependencies
  // jhipster-needle-gradle-runtime-dependencies
  testImplementation(libs.junit.engine)
  testImplementation(libs.junit.params)
  testImplementation(libs.assertj)
  testImplementation(libs.mockito)
  // jhipster-needle-gradle-test-dependencies
}

// jhipster-needle-gradle-free-configuration-blocks

tasks.test {
  filter {
    includeTestsMatching("**Test*")
    excludeTestsMatching("**IT*")
    excludeTestsMatching("**CucumberTest*")
  }
  useJUnitPlatform()
}

val integrationTest = task<Test>("integrationTest") {
  description = "Runs integration tests."
  group = "verification"
  shouldRunAfter("test")
  filter {
    includeTestsMatching("**IT*")
    includeTestsMatching("**CucumberTest*")
    excludeTestsMatching("**Test*")
  }
  useJUnitPlatform()
}
