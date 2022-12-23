package co.tractionapps.weatherapp.data.source.remote.forcasts

import co.tractionapps.weatherapp.data.source.remote.api.WeatherApi
import co.tractionapps.weatherapp.data.source.remote.forcasts.response.WeatherResponse
import retrofit2.Response

class DefaultWeatherDataSource(private val weatherApi: WeatherApi): RemoteWeatherDataSource {

    override suspend fun fetchWeatherData(queryParam: Map<String, String>): Response<WeatherResponse> {
        return weatherApi.forCastBasedOnCountry(options = queryParam)
    }
}