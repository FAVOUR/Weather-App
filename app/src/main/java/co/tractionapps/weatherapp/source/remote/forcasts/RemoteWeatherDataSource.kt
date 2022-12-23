package co.tractionapps.weatherapp.source.remote.forcasts

import co.tractionapps.weatherapp.source.remote.forcasts.response.WeatherResponse
import retrofit2.Response

interface RemoteWeatherDataSource {
    suspend fun fetchWeatherData(queryParam: Map<String,String>): Response<WeatherResponse>
}