plugins {
  id(BuildPlugins.kotlin)
}

dependencies {
  implementation(KotlinDependencies.stdLib)
  implementation(RxJavaDependencies.rxJava)

  testImplementation(TestingDependencies.assertJ)
  testImplementation(TestingDependencies.junit)
  testImplementation(TestingDependencies.mockitoKt)

}

