package co.tractionapps.weatherapp.data.source.remote.forecasts.response

import co.tractionapps.weatherapp.data.source.local.WeatherEntity
import co.tractionapps.weatherapp.data.source.remote.forecasts.response.weather_response_objects.City
import co.tractionapps.weatherapp.data.source.remote.forecasts.response.weather_response_objects.ForecastData

//Model
data class WeatherResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<ForecastData>,
    val message: Int,
)

//mapper
fun ForecastData.toWeatherEntity(metric: String, city: City): WeatherEntity {
    return WeatherEntity(
        timeInMillInUTC = dt,
        city = city.name,
        country = city.country,
        temp = main.temp,
        tempFeelsLike = main.feels_like,
        minTemp = main.temp,
        maxTemp = main.temp_max,
        humidity = main.humidity,
        uvIndex = "",
        windSpeed = wind.speed,
        weatherDescription = weather[0].description,
        weatherCondition = weather[0].main,
        metric = metric,
        icon = weather[0].icon)
}