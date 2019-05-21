package de.iskae.remote.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

const val OWM_BASE_URL = "http://api.openweathermap.org"
const val TIMEOUT_SECONDS = 120L

class OpenWeatherMapServiceFactory {
    fun buildOpenWeatherMapService(isDebug: Boolean): OpenWeatherMapService {
        val okHttpClient = buildOkHttpClient(
            buildLoggingInterceptor((isDebug))
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

    private fun buildOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
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
}