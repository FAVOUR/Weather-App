package co.favour.weatherapp.data.source.repository

import co.favour.weatherapp.model.WeatherData
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun observeWeather(): Flow<List<WeatherData>>
    suspend fun updateWeatherByCountryandMetric(metric: String, cityOrCountry: String)
}