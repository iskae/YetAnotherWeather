plugins {
    id(BuildPlugins.kotlin)
}

dependencies {
    implementation(project(ProjectModules.data))

    implementation(KotlinDependencies.stdLib)
    implementation(CommonDependencies.javaxInject)
    implementation(CommonDependencies.javaxAnnotation)
    implementation(RxJavaDependencies.rxKotlin)
    implementation(NetworkDependencies.okHttp)
    implementation(NetworkDependencies.loggingInterceptor)
    implementation(NetworkDependencies.moshi)
    implementation(NetworkDependencies.retrofitMoshiConverter)
    implementation(NetworkDependencies.retrofitRxjavaAdapter)

    testImplementation(TestingDependencies.assertJ)
    testImplementation(TestingDependencies.junit)
    testImplementation(TestingDependencies.mockitoKt)
    testImplementation(TestingDependencies.mockitoInline)

}

