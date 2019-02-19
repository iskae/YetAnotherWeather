plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}
android {
    compileSdkVersion(Versions.compile_sdk)
    defaultConfig {
        applicationId = "de.iskae.yetanotherweather"
        minSdkVersion(Versions.min_sdk)
        targetSdkVersion(Versions.target_sdk)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Deps.androidx_appcompat)
    implementation(Deps.androidx_material_design)
    implementation(Deps.androidx_constraintlayout)

    /*********** Kotlin ***************/
    implementation(Deps.kotlin_stdlib)

    /*********** Dagger 2 ***************/
    implementation(Deps.dagger_android)
    implementation(Deps.dagger_support)
    kapt(Deps.dagger_processor)
    kapt(Deps.dagger_compiler)

    /*********** LiveData & ViewModel  ***************/
    implementation(Deps.lifecycle_components)
    implementation(Deps.lifecycle_runtime)
    kapt(Deps.lifecycle_compiler)

    testImplementation(Testing.junit)

    androidTestImplementation(Testing.espresso_core)
    androidTestImplementation(Testing.runner)
    androidTestImplementation(Testing.rules)

}