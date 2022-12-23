package co.tractionapps.weatherapp.data.source.repository

import co.tractionapps.weatherapp.data.Constants.COUNTRY_KEY
import co.tractionapps.weatherapp.data.Constants.DEFAULT_COUNTRY
import co.tractionapps.weatherapp.data.Constants.UNITS_KEY
import co.tractionapps.weatherapp.data.source.local.WeatherDao
import co.tractionapps.weatherapp.data.source.local.toWeatherData
import co.tractionapps.weatherapp.data.source.remote.forcasts.RemoteWeatherDataSource
import co.tractionapps.weatherapp.data.source.remote.forcasts.response.toWeatherEntity
import co.tractionapps.weatherapp.model.WeatherData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Response

class DefaultWeatherRepo(
    private val remoteWeatherDataSource: RemoteWeatherDataSource,
    private val weatherDao: WeatherDao,
) : WeatherRepository {

    override fun observeWeather(): Flow<List<WeatherData>> {
        return weatherDao.observeWeather().map { weatherItems ->
            weatherItems.map { weatherEntity ->
                weatherEntity.toWeatherData()
            }
        }
    }

    override suspend fun updateWeatherByCountryandMetric(metric: String, cityOrCountry: String) {
        val queryParameters = mapOf(UNITS_KEY to metric, COUNTRY_KEY to DEFAULT_COUNTRY)
        val response = remoteWeatherDataSource.fetchWeatherData(queryParameters).extractResponse()
        weatherDao.deleteAllData()
        response.list.map { forecastData ->
            val city = response.city
            val weatherEntity = forecastData.toWeatherEntity(metric,city)
            weatherDao.saveCurrentWeatherCondition(weatherEntity)
        }
    }

    private fun  <T> Response<T>.extractResponse(): T{
        return if(isSuccessful){
            body()!!
        }else{
           throw Throwable("An Error Occurred")
        }
    }

}