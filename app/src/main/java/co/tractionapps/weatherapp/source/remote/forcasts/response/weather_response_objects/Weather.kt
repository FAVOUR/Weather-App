package co.tractionapps.weatherapp.source.remote.forcasts.response.weather_response_objects

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)