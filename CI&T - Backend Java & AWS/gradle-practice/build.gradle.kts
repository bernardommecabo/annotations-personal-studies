plugins {
    id("java")
    checkstyle
}

group = "br.bernardomecabo.gradle"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    implementation("org.projectlombok:lombok-mapstruct-binding:0.2.0")

    compileOnly("org.projectlombok:lombok:1.18.38")

    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
}

tasks.withType<Checkstyle>().configureEach {
    reports {
        xml.required = true
        html.required = true
    }
}

tasks.checkstyleMain{
    source = fileTree("src/main/java") {}
}
