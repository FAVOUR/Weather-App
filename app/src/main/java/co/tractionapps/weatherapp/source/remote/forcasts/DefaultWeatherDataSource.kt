package co.tractionapps.weatherapp.source.remote.forcasts

import co.tractionapps.weatherapp.source.remote.api.WeatherApi
import co.tractionapps.weatherapp.source.remote.forcasts.response.WeatherResponse
import retrofit2.Response

class DefaultWeatherDataSource(val weatherApi: WeatherApi):RemoteWeatherDataSource {

    override suspend fun fetchWeatherData(queryParam: Map<String, String>): Response<WeatherResponse> {
        return weatherApi.forCastBasedOnCountry(options = queryParam)
    }
}