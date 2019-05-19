plugins {
    id(BuildPlugins.kotlin)
}

dependencies {
    implementation(project(ProjectModules.domain))

    implementation(KotlinDependencies.stdLib)
    implementation(CommonDependencies.inject)
    implementation(RxJava.rxJava)

    implementation(TestingDependencies.assertJ)
    implementation(TestingDependencies.junit)
    implementation(TestingDependencies.mockitoKt)

}

