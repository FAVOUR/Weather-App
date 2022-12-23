package co.tractionapps.weatherapp.data.source.repository

import co.tractionapps.weatherapp.model.WeatherData
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun observeWeather(): Flow<List<WeatherData>>
    suspend fun updateWeatherByCountryandMetric(metric: String, cityOrCountry: String)
}