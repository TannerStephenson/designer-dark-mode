plugins {
    `java-library`
}

java {
    toolchain {
        languageVersion.set(org.gradle.jvm.toolchain.JavaLanguageVersion.of(11))
    }
}

dependencies {
    compileOnly("com.inductiveautomation.ignitionsdk:designer-api:${rootProject.extra["sdk_version"]}")
    compileOnly("com.inductiveautomation.ignitionsdk:ignition-common:${rootProject.extra["sdk_version"]}")

    // add designer scoped dependencies here
    compileOnly("com.formdev:flatlaf:3.2")
}

tasks.register<Copy>("copyFlatLafJar") {
    from("src/main/resources/lib")      // source folder
    into("$buildDir/libs")              // output folder
}

tasks.named("build") {
    dependsOn("copyFlatLafJar")         // make sure the copy runs before build
}

tasks.withType<Jar> {
    from("$buildDir/libs") {            // include the copied jars
        include("*.jar")
    }
}
