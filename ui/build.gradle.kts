import java.io.FileInputStream
import java.util.*

plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.safeArgs)
}

val props = Properties()
val localProperties: File = project.rootProject.file("local.properties")
if (localProperties.exists()) {
    props.load(FileInputStream(localProperties))
}
if (!props.containsKey("owm.apikey")) {
    if (rootProject.properties["OWM_APIKEY"] != null) {
        props["owm.apikey"] = rootProject.properties["OWM_APIKEY"]
    } else {
        props["owm.apikey"] = "\"\""
    }
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

        buildConfigField("String", "OWM_APIKEY", props["owm.apikey"] as String)
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
    implementation(project(ProjectModules.domain))
    implementation(project(ProjectModules.data))
    implementation(project(ProjectModules.remote))
    implementation(project(ProjectModules.cache))
    implementation(project(ProjectModules.presentation))

    implementation(CommonDependencies.javaxInject)
    implementation(KotlinDependencies.stdLib)
    implementation(CommonDependencies.javaxAnnotation)
    implementation(RxJavaDependencies.rxKotlin)
    implementation(RxJavaDependencies.rxAndroid)

    implementation(AndroidDependencies.appCompat)
    implementation(AndroidDependencies.materialDesign)
    implementation(AndroidDependencies.constraintLayout)

    implementation(KotlinDependencies.stdLib)

    implementation(DaggerDependencies.daggerAndroid)
    implementation(DaggerDependencies.daggerSupport)
    kapt(DaggerDependencies.daggerProcessor)
    kapt(DaggerDependencies.daggerCompiler)

    implementation(AndroidDependencies.lifecycleCommon)
    implementation(AndroidDependencies.lifecycleRuntime)
    kapt(AndroidDependencies.lifecycleCompiler)

    implementation(CommonDependencies.timber)

    implementation(AndroidDependencies.navigationUi)
    implementation(AndroidDependencies.navigationFragment)
    implementation(AndroidDependencies.navigationFragmentKtx)

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