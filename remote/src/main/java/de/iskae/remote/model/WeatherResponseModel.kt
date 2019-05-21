package de.iskae.remote.model

data class WeatherResponseModel(
    val id: Long,
    val clouds: CloudsModel,
    val coord: CoordModel,
    val weather: List<WeatherModel>,
    val main: MainModel,
    val visibility: Int,
    val wind: WindModel,
    val dt: Long,
    val sys: SysModel,
    val name: String
)