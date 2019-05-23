plugins {
  id(BuildPlugins.kotlin)
}

dependencies {
  implementation(project(ProjectModules.domain))

  implementation(KotlinDependencies.stdLib)
  implementation(RxJavaDependencies.rxJava)

  testImplementation(TestingDependencies.assertJ)
  testImplementation(TestingDependencies.junit)
  testImplementation(TestingDependencies.mockitoKt)
  testImplementation(TestingDependencies.mockitoInline)

}

