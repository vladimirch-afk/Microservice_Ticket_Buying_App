pluginManagement {
    plugins {
        kotlin("jvm") version "2.0.0"
        kotlin("plugin.spring") version "2.0.0"
        id("org.springframework.boot") version "3.2.2"
        id("io.spring.dependency-management") version "1.1.5"
    }

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

include("application")
include("authentication")