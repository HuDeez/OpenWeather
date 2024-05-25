plugins {
    id("java")
}

group = "org.HuDeez"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.json:json:20240303")
}

tasks.test {
    useJUnitPlatform()
}