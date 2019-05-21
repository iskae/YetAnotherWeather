plugins {
    id(BuildPlugins.kotlin)
}

dependencies {
    implementation(KotlinDependencies.stdLib)
    implementation(CommonDependencies.javaxInject)
    implementation(RxJavaDependencies.rxJava)

    testImplementation(TestingDependencies.assertJ)
    testImplementation(TestingDependencies.junit)
    testImplementation(TestingDependencies.mockitoKt)

}

