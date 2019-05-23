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
    multiDexEnabled = true
  }
}

dependencies {
  implementation(project(ProjectModules.domain))

  implementation(CommonDependencies.javaxInject)
  implementation(KotlinDependencies.stdLib)
  implementation(CommonDependencies.javaxAnnotation)
  implementation(RxJavaDependencies.rxKotlin)
  implementation(RxJavaDependencies.rxAndroid)
  implementation(AndroidDependencies.lifecycleRuntime)
  implementation(AndroidDependencies.lifecycleExtensions)

  kapt(AndroidDependencies.lifecycleCompiler)

  testImplementation(TestingDependencies.assertJ)
  testImplementation(TestingDependencies.junit)
  testImplementation(TestingDependencies.mockitoKt)
  testImplementation(TestingDependencies.mockitoInline)
  testImplementation(TestingDependencies.robolectric)
  testImplementation(TestingDependencies.archTesting)
  testImplementation(TestingDependencies.roomTesting)
}