plugins {
    id(BuildPlugins.kotlin)
}

dependencies {
    implementation(project(ProjectModules.domain))

    implementation(KotlinDependencies.stdLib)
    implementation(CommonDependencies.inject)
    implementation(RxJava.rxJava)

    testImplementation(TestingDependencies.assertJ)
    testImplementation(TestingDependencies.junit)
    testImplementation(TestingDependencies.mockitoKt)
    testImplementation(TestingDependencies.mockitoInline)

}

