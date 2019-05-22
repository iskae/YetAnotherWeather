package de.iskae.ui.mapper

import de.iskae.presentation.model.WeatherView
import de.iskae.ui.model.Weather
import javax.inject.Inject

class WeatherViewMapper @Inject constructor() : ViewMapper<WeatherView, Weather> {
    override fun mapToView(presentation: WeatherView): Weather {
        return Weather(
            id = presentation.id,
            latitude = presentation.latitude,
            longitude = presentation.longitude,
            description = presentation.description,
            iconId = presentation.iconId,
            temperature = presentation.temperature,
            pressure = presentation.pressure,
            tempMax = presentation.tempMax,
            tempMin = presentation.tempMin,
            windSpeed = presentation.windSpeed,
            windDegree = presentation.windDegree,
            cloudinessPercentage = presentation.cloudinessPercentage,
            sunrise = presentation.sunrise,
            sunset = presentation.sunset
        )
    }
}