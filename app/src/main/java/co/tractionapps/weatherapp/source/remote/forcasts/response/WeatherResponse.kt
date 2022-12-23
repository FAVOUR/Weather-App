package co.tractionapps.weatherapp.source.remote.forcasts.response

import co.tractionapps.weatherapp.source.remote.forcasts.response.weather_response_objects.City
import co.tractionapps.weatherapp.source.remote.forcasts.response.weather_response_objects.ForecastData

data class WeatherResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<ForecastData>,
    val message: Int
)