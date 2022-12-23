package co.tractionapps.weatherapp.source.remote.forcasts.response.weather_response_objects

data class ForecastData (
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: Main,
    val pop: Int,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)