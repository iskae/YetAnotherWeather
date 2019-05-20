package de.iskae.remote.service

import de.iskae.remote.model.WeatherResponseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapService {

    @GET("data/2.5/weather")
    fun getCurrentWeatherByCity(
        @Query("APPID") appId: String,
        @Query("q") city: String,
        @Query("units") unit: String = "metric"
    ): Observable<WeatherResponseModel>
}