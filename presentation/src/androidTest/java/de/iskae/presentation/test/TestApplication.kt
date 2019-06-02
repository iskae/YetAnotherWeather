package de.iskae.presentation.test

import android.app.Activity
import android.app.Application
import androidx.test.platform.app.InstrumentationRegistry
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import de.iskae.presentation.di.DaggerTestApplicationComponent
import de.iskae.presentation.di.TestApplicationComponent
import javax.inject.Inject

class TestApplication : Application(), HasActivityInjector {

  @Inject
  lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
  private lateinit var testAppComponent: TestApplicationComponent

  companion object {
    fun appComponent(): TestApplicationComponent {
      return (InstrumentationRegistry.getInstrumentation().targetContext.applicationContext
          as TestApplication).testAppComponent
    }
  }

  override fun onCreate() {
    super.onCreate()
    testAppComponent = DaggerTestApplicationComponent.builder().application(this).build()
    testAppComponent.inject(this)
  }

  override fun activityInjector(): AndroidInjector<Activity> {
    return dispatchingAndroidInjector
  }
}