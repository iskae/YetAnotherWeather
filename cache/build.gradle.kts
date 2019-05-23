plugins {
  id(BuildPlugins.androidLibrary)
  id(BuildPlugins.kotlinAndroid)
  id(BuildPlugins.kotlinKapt)
}
android {
  compileSdkVersion(AndroidSdk.compile)
  buildToolsVersion(AndroidSdk.buildTools)
  defaultConfig {
    minSdkVersion(AndroidSdk.min)
    targetSdkVersion(AndroidSdk.target)
  }
}

dependencies {
  implementation(project(ProjectModules.data))

  implementation(KotlinDependencies.stdLib)
  implementation(RxJavaDependencies.rxKotlin)
  api(AndroidDependencies.roomRuntime)
  implementation(AndroidDependencies.roomRxJava)

  kapt(AndroidDependencies.roomCompiler)

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