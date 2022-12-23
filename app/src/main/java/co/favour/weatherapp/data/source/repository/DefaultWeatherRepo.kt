package co.favour.weatherapp.data.source.repository

import co.favour.weatherapp.data.Constants.COUNTRY_KEY
import co.favour.weatherapp.data.Constants.DEFAULT_COUNTRY
import co.favour.weatherapp.data.Constants.UNITS_KEY
import co.favour.weatherapp.data.source.local.WeatherDao
import co.favour.weatherapp.data.source.local.toWeatherData
import co.favour.weatherapp.data.source.remote.forecasts.RemoteWeatherDataSource
import co.favour.weatherapp.data.source.remote.forecasts.response.toWeatherEntity
import co.favour.weatherapp.model.WeatherData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class DefaultWeatherRepo @Inject constructor(
    private val remoteWeatherDataSource: RemoteWeatherDataSource,
    private val weatherDao: WeatherDao,
    private val ioDispatcher: CoroutineDispatcher,

    ) : WeatherRepository {

    override fun observeWeather(): Flow<List<WeatherData>> {
        return weatherDao.observeWeather().map { weatherItems ->
            weatherItems.map { weatherEntity ->
                weatherEntity.toWeatherData()
            }
        }
    }

    override suspend fun updateWeatherByCountryandMetric(metric: String, cityOrCountry: String) {
        withContext(ioDispatcher) {

            val queryParameters = mapOf(UNITS_KEY to metric, COUNTRY_KEY to DEFAULT_COUNTRY)
            val response =
                remoteWeatherDataSource.fetchWeatherData(queryParameters).extractResponse()
            weatherDao.deleteAllData()
            response.list.map { forecastData ->
                val city = response.city
                val weatherEntity = forecastData.toWeatherEntity(metric, city)
                weatherDao.saveCurrentWeatherCondition(weatherEntity)
            }
        }
    }

    private fun <T> Response<T>.extractResponse(): T {
        return if (isSuccessful) {
            body()!!
        } else {
            throw Throwable("An Error Occurred")
        }
    }

}