plugins {
  java
  id("io.quarkus")
  id("io.swagger.core.v3.swagger-gradle-plugin") version "2.2.22"
}

repositories {
  mavenCentral()
  mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project
val quarkusPluginId: String by project
val quarkusCamelPluginId: String by project
val lombokVersion: String by project
val mapstructVersion: String by project
val lombokMapStructBindingVersion: String by project

dependencies {
  implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))

  implementation("${quarkusPluginId}:quarkus-container-image-docker")
  implementation("${quarkusPluginId}:quarkus-grpc")
  implementation("${quarkusPluginId}:quarkus-mutiny")
  implementation("${quarkusPluginId}:quarkus-rest")
  implementation("${quarkusPluginId}:quarkus-rest-jackson")
  implementation("${quarkusPluginId}:quarkus-arc")
  implementation("${quarkusPluginId}:quarkus-smallrye-openapi")
  implementation("${quarkusPluginId}:quarkus-messaging-rabbitmq")


  compileOnly("org.projectlombok:lombok:${lombokVersion}")
  annotationProcessor("org.projectlombok:lombok:${lombokVersion}")

  implementation("org.mapstruct:mapstruct:${mapstructVersion}")
  annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")

  implementation("org.projectlombok:lombok-mapstruct-binding:${lombokMapStructBindingVersion}")
  annotationProcessor("org.projectlombok:lombok-mapstruct-binding:${lombokMapStructBindingVersion}")

  testImplementation("${quarkusPluginId}:quarkus-junit5")
  testImplementation("io.rest-assured:rest-assured")
}

group = "org.gateway"
version = "1.0.0-SNAPSHOT"

java {
  sourceCompatibility = JavaVersion.VERSION_21
  targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<Test> {
  systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
tasks.withType<JavaCompile> {
  options.encoding = "UTF-8"
  options.compilerArgs.add("-parameters")
}
