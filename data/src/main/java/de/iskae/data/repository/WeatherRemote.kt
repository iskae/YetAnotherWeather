package de.iskae.data.repository

import de.iskae.data.model.WeatherDataEntity
import io.reactivex.Observable

interface WeatherRemote {
    fun getCurrentWeatherData(): Observable<WeatherDataEntity>
}