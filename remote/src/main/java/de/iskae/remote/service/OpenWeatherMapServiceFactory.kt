package de.iskae.remote.service

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

const val OWM_BASE_URL = "http://api.openweathermap.org"
const val TIMEOUT_SECONDS = 120L

class OpenWeatherMapServiceFactory {
  fun buildOpenWeatherMapService(
      isDebug: Boolean, apiKey: String
  ): OpenWeatherMapService {
    val okHttpClient = buildOkHttpClient(
        buildLoggingInterceptor((isDebug)),
        buildApiKeyInterceptor(apiKey)
    )
    return buildOpenWeatherMapService(okHttpClient)
  }

  private fun buildOpenWeatherMapService(okHttpClient: OkHttpClient): OpenWeatherMapService {
    val retrofit = Retrofit.Builder()
        .baseUrl(OWM_BASE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    return retrofit.create(OpenWeatherMapService::class.java)
  }

  private fun buildOkHttpClient(
      httpLoggingInterceptor: HttpLoggingInterceptor,
      apiKeyInterceptor: Interceptor
  ): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(apiKeyInterceptor)
        .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .build()
  }

  private fun buildLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = if (isDebug) {
      HttpLoggingInterceptor.Level.BODY
    } else {
      HttpLoggingInterceptor.Level.NONE
    }
    return logging
  }

  private fun buildApiKeyInterceptor(apiKey: String): Interceptor {
    return Interceptor { chain ->
      val original = chain.request()
      val originalHttpUrl = original.url()

      val url = originalHttpUrl.newBuilder()
          .addQueryParameter("appid", apiKey)
          .build()

      val requestBuilder = original.newBuilder()
          .url(url)

      val request = requestBuilder.build()
      return@Interceptor chain.proceed(request)
    }
  }
}