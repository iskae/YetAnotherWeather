plugins {
  id(BuildPlugins.androidApplication)
  id(BuildPlugins.kotlinAndroid)
  id(BuildPlugins.kotlinAndroidExtensions)
  id(BuildPlugins.kotlinKapt)
}
android {
  compileSdkVersion(AndroidSdk.compile)
  defaultConfig {
    applicationId = "de.iskae.yetanotherweather"
    minSdkVersion(AndroidSdk.min)
    targetSdkVersion(AndroidSdk.target)
    versionCode = 1
    versionName = "1.0"
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables.useSupportLibrary = true
    multiDexEnabled = true
  }
  dataBinding.isEnabled = true

  buildTypes {
    getByName("release") {
      isDebuggable = false
      isTestCoverageEnabled = false
    }

    getByName("debug") {
      applicationIdSuffix = ".debug"
    }
  }

  compileOptions {
    targetCompatibility = JavaVersion.VERSION_1_8
    sourceCompatibility = JavaVersion.VERSION_1_8
  }
}

kapt {
  useBuildCache = true
}

dependencies {
  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

  implementation(AndroidDependencies.appCompat)
  implementation(AndroidDependencies.materialDesign)
  implementation(AndroidDependencies.constraintLayout)

  /*********** Kotlin ***************/
  implementation(KotlinDependencies.stdLib)

  /*********** Dagger 2 ***************/
  implementation(DaggerDependencies.daggerAndroid)
  implementation(DaggerDependencies.daggerSupport)
  kapt(DaggerDependencies.daggerProcessor)
  kapt(DaggerDependencies.daggerCompiler)

  /*********** LiveData & ViewModel  ***************/
  implementation(AndroidDependencies.lifecycleCommon)
  implementation(AndroidDependencies.lifecycleRuntime)
  kapt(AndroidDependencies.lifecycleCompiler)

  implementation(CommonDependencies.timber)

  debugImplementation(CommonDependencies.leakCanary)
  debugImplementation(CommonDependencies.leakCanaryFragment)
  releaseImplementation(CommonDependencies.leakCanaryNoOp)

  testImplementation(TestingDependencies.assertJ)
  testImplementation(TestingDependencies.junit)
  testImplementation(TestingDependencies.mockitoKt)
  testImplementation(TestingDependencies.mockitoInline)
  testImplementation(TestingDependencies.robolectric)
  testImplementation(TestingDependencies.archTesting)
  testImplementation(TestingDependencies.roomTesting)

  androidTestImplementation(TestingDependencies.junit)
  androidTestImplementation(TestingDependencies.androidJUnit)
  androidTestImplementation(TestingDependencies.runner)
  androidTestImplementation(TestingDependencies.rules)

}