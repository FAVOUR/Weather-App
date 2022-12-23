package co.favour.weatherapp.data.source.remote.forecasts.response.weather_response_objects

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String,
)