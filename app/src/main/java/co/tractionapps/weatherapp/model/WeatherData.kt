package co.tractionapps.weatherapp.model

class WeatherData(
    val timeInMills: Long,
    val location: String,
    val country: String,
    val temprature: Double,
    val feelsLike: Double,
    val minTemprature: Double,
    val maxTemp: Double,
    val humidity: Double,
    val uvIndex: String,
    val windSpeed: Double,
    val weatherDescription: String,
    val weatherCondition: String,
    val icon: String,
    val metric: String,
)