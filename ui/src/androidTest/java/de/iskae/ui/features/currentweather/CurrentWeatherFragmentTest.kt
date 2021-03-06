package de.iskae.ui.features.currentweather

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.nhaarman.mockitokotlin2.whenever
import de.iskae.domain.model.Weather
import de.iskae.ui.MainActivity
import de.iskae.ui.test.TestApplication
import de.iskae.ui.test.factory.TestWeatherFactory
import io.reactivex.Observable
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString

@RunWith(AndroidJUnit4::class)
class CurrentWeatherFragmentTest {

  @Rule
  @JvmField
  val activity = ActivityTestRule<MainActivity>(
    MainActivity::class.java, false,
    false
  )

  @Test
  fun activityLaunches() {
    stubGetCurrentWeather(Observable.just(TestWeatherFactory.mockTestWeather()))
    activity.launchActivity(null)
  }

  private fun stubGetCurrentWeather(observable: Observable<Weather>) {
    whenever(TestApplication.appComponent().weatherRepository().getCurrentWeatherByCityId(anyString(), anyString()))
      .thenReturn(observable)
  }
}