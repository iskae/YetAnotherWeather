/**
 * Versions for libraries used within the projects
 */

const val kotlinVersion = "1.3.31"
const val navigationVersion = "2.1.0-alpha03"
const val lifecycleVersion = "2.2.0-alpha01"

object AndroidSdk {
    const val min = 23
    const val compile = 28
    const val target = compile
}

object ProjectModules {
    const val core = ":core"
}

object BuildPlugins {
    private object Versions {
        const val androidBuildTools = "3.5.0-beta01"
    }

    const val androidGradle = "com.android.tools.build:gradle:${Versions.androidBuildTools}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val gradleVersions = "com.github.ben-manes.versions"
    const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion"

    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
}

object CommonDependencies {
    private object Versions {
        const val firebase = "11.6.2"
        const val crashlytics = "2.2.3"
        const val picasso = "2.71828"
        const val leakCanary = "1.6.3"
        const val timber = "4.7.1"
    }

    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}@aar"
    const val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"
    const val firebase_core = "com.google.firebase:firebase-core:${Versions.firebase}"
    const val firebase_messaging = "com.google.firebase:firebase-messaging:${Versions.firebase}"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    const val leakCanaryFragment = "com.squareup.leakcanary:leakcanary-support-fragment:${Versions.leakCanary}"
    const val leakCanaryNoOp = "com.squareup.leakcanary:leakcanary-android-no-op:${Versions.leakCanary}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

object AndroidDependencies {
    private object Versions {
        const val jetpack = "1.1.0-alpha05"
        const val recyclerView = "1.0.0"
        const val androidAnnotations = "1.0.1"
        const val materialDesign = "1.1.0-alpha06"
        const val constraintLayout = "2.0.0-beta1"
        const val ktx = "1.0.1"
    }

    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val androidAnnotations = "androidx.annotation:annotation:${Versions.androidAnnotations}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val navigation = "androidx.navigation:navigation-runtime:$navigationVersion"
    const val navigationFragment = "androidx.navigation:navigation-fragment:$navigationVersion"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:$navigationVersion"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:$lifecycleVersion"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:$lifecycleVersion"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:$lifecycleVersion"
    const val lifecycleReactiveStreams = "android.arch.lifecycle:reactivestreams:$lifecycleVersion"
}

object KotlinDependencies {
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
}

object DaggerDependencies {
    private object Versions {
        const val dagger = "2.22.1"
    }

    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
}

object RxJava {
    private object Versions {
        const val rxJava = "2.1.4"
        const val rxAndroid = "2.0.1"
        const val rxKotlin = "2.1.0"
        const val rxRelay = "2.1.0"
    }

    const val rxJava = "io.reactivex.rxjava2:rxJava:${Versions.rxJava}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    const val rxjava_kotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
    const val rxRelay = "com.jakewharton.rxrelay2:rxrelay:${Versions.rxRelay}"
}

object NetworkDependencies {
    private object Versions {
        const val moshi = "1.4.0"
        const val okhttp = "3.9.1"
        const val retrofit = "2.3.0"
    }

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val retrofitRxjavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
}

object TestingDependencies {
    private object Versions {
        const val junit = "4.13-beta-3"
        const val mockito = "2.23.4"
        const val mockitoKt = "2.1.0"
        const val robolectric = "3.8"
        const val robolectricSupport = "3.8"
        const val espresso = "3.2.0-beta01"
        const val assertJ = "3.11.1"
    }

    const val archTesting = "android.arch.core:core-testing:$lifecycleVersion"
    const val mockitoKt = "com.nhaarman:mockito-kotlin-kt1.1:${Versions.mockitoKt}"
    const val junit = "junit:junit:${Versions.junit}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val robolectricShadowsSupport = "org.robolectric:shadows-supportv4:${Versions.robolectricSupport}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val espressoIntents = "androidx.test.espresso:espresso-intents:${Versions.espresso}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
    const val assertJ = "org.assertj:assertj-core:${Versions.assertJ}"
}