// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  id(BuildPlugins.gradleVersions) version "0.21.0"
}

buildscript {
  repositories {
    google()
    jcenter()
  }
  dependencies {
    classpath(BuildPlugins.androidGradle)
    classpath(BuildPlugins.kotlinGradle)
    classpath(BuildPlugins.safeArgs)

    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle.kts.kts files
  }
}

allprojects {
  repositories {
    google()
    jcenter()
  }
}

task<Delete>("clean") {
  delete(rootProject.buildDir)
}

