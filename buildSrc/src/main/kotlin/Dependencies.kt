/**
 * Versions for libraries used within the projects
 */
object Versions {
    val min_sdk = 23
    val target_sdk = 28
    val compile_sdk = 28
    val build_tools_version = "28.0.1"
    val android_gradle_plugin_version = "3.2.1"

    val androidx_version = "1.0.0"
    val multidex_version = "2.0.0"
    val navigation_version = "1.0.0-alpha07"
    val junit_version = "4.12"
    val dagger_version = "2.16"
    val okhttp3_version = "3.9.1"
    val databinding_version = "3.1.3"
    val lifecycle_version = "2.0.0"
    val kotlin_version = "1.2.51"

    val mockito_version = "2.13.0"
    val robolectric_version = "3.8"
    val robolectric_support_version = "3.8"
    val moshi_version = "1.4.0"
    val constraint_version = "1.1.2"
    val rxjava_version = "2.1.4"
    val rxandroid_version = "2.0.1"
    val rxkotlin_version = "2.1.0"
    val retrofit_version = "2.3.0"
    val mockito_kt_version = "1.5.0"
    val firebase_version = "11.6.2"
    val couchbase_lite_version = "1.4.1"
    val threetenabp_version = "1.0.5"
    val apache_commons_io_version = "2.6"
    val crashlytics_version = "2.2.3"
    val picasso_version = "2.71828"
    val espresso = "3.1.0"
    val test_runner = "1.1.0"
    val test_rules = "1.1.0"
    val leak_canary = "1.6.3"
    val timber = "4.7.1"
}

object Plugins {
    val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin_version}"
    val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
    val dokka_plugin = "org.jetbrains.dokka:dokka-android-gradle-plugin:0.9.17"
    val safe_args_plugin = "android.arch.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation_version}"
}

object Deps {
    val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger_version}"
    val dagger_processor = "com.google.dagger:dagger-android-processor:${Versions.dagger_version}"
    val dagger = "com.google.dagger:dagger:${Versions.dagger_version}"
    val dagger_android = "com.google.dagger:dagger-android:${Versions.dagger_version}"
    val dagger_support = "com.google.dagger:dagger-android-support:${Versions.dagger_version}"
    val webtrekk = "com.webtrekk.webtrekksdk:WebtrekkSDK:4.5.0"
    val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava_version}"
    val rxjava_android = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid_version}"
    val rxjava_kotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin_version}"

    val multidex = "androidx.multidex:multidex:${Versions.multidex_version}"
    val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.androidx_version}"
    val androidx_recyclerview = "androidx.recyclerview:recyclerview:${Versions.androidx_version}"
    val androidx_annotations = "androidx.annotation:annotation:${Versions.androidx_version}"
    val androidx_material_design = "com.google.android.material:material:${Versions.androidx_version}"
    val androidx_cardview = "\tandroidx.cardview.widget.CardView:${Versions.androidx_version}"
    val androidx_constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_version}"
    val androidx_navigation = "android.arch.navigation:navigation-runtime:${Versions.androidx_version}"
    val androidx_navigation_ktx = "android.arch.navigation:navigation-runtime-ktx:${Versions.navigation_version}"
    val androidx_navigation_fragment =
        "android.arch.navigation:navigation-fragment:${Versions.navigation_version}"
    val androidx_navigation_fragment_ktx =
        "android.arch.navigation:navigation-fragment-ktx:${Versions.navigation_version}"
    val androidx_navigation_safe_args_plugin =
        "android.arch.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation_version}"
    val androidx_navigation_ui = "android.arch.navigation:navigation-ui-ktx:${Versions.navigation_version}"
    val androidx_lifecycle_compiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle_version}"

    val firebase_core = "com.google.firebase:firebase-core:${Versions.firebase_version}"
    val firebase_messaging = "com.google.firebase:firebase-messaging:${Versions.firebase_version}"

    val moshi = "com.squareup.moshi:moshi:${Versions.moshi_version}"

    val retrofit_moshi_converter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit_version}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    val retrofit_rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit_version}"

    val couchbase_lite = "com.couchbase.lite:couchbase-lite-android:${Versions.couchbase_lite_version}"
    val couchabse_lite_sqlcipher =
        "com.couchbase.lite:couchbase-lite-android-sqlcipher:${Versions.couchbase_lite_version}"

    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
    val threetenabp_android = "com.jakewharton.threetenabp:threetenabp:${Versions.threetenabp_version}"
    val apache_commons_io = "commons-io:commons-io:${Versions.apache_commons_io_version}"

    val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics_version}@aar"

    val picasso = "com.squareup.picasso:picasso:${Versions.picasso_version}"

    val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle_version}"
    val lifecycle_components = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle_version}"
    val lifecycle_compiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle_version}"
    val lifecycle_reactive_streams = "android.arch.lifecycle:reactivestreams:${Versions.lifecycle_version}"
    val leak_canary = "com.squareup.leakcanary:leakcanary-android:${Versions.leak_canary}"
    val leak_canary_fragments = "com.squareup.leakcanary:leakcanary-support-fragment:${Versions.leak_canary}"
    val leak_canary_no_op = "com.squareup.leakcanary:leakcanary-android-no-op:${Versions.leak_canary}"

    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

object Testing {
    val architecture_components_testing = "android.arch.core:core-testing:${Versions.lifecycle_version}"
    val mockito_kotlin = "com.nhaarman:mockito-kotlin-kt1.1:${Versions.mockito_kt_version}"
    val junit = "junit:junit:${Versions.junit_version}"
    val mockito = "org.mockito:mockito-core:${Versions.mockito_version}"
    val robolectric = "org.robolectric:robolectric:${Versions.robolectric_version}"
    val robolectric_shadows_support = "org.robolectric:shadows-supportv4:${Versions.robolectric_support_version}"
    val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val runner = "androidx.test:runner:${Versions.test_runner}"
    val rules = "androidx.test:rules:${Versions.test_rules}"
}