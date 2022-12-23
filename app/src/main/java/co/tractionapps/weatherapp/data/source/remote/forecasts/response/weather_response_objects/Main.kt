package co.tractionapps.weatherapp.data.source.remote.forecasts.response.weather_response_objects

data class Main(
    val feels_like: Double,
    val grnd_level: Int,
    val humidity: Double,
    val pressure: Int,
    val sea_level: Int,
    val temp: Double,
    val temp_kf: Double,
    val temp_max: Double,
    val temp_min: Double,
)