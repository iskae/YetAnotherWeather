package de.iskae.remote.model

data class WeatherResponseModel(
    val clouds: CloudsModel,
    val coord: CoordModel,
    val weather: List<WeatherModel>,
    val main: MainModel,
    val visibility: Int,
    val wind: WindModel,
    val dt: Long,
    val sys: SysModel,
    val id: Int,
    val name: String
)