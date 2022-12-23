package co.favour.weatherapp.data.source.remote.forecasts

import co.favour.weatherapp.data.source.remote.api.WeatherApi
import co.favour.weatherapp.data.source.remote.forecasts.response.WeatherResponse
import retrofit2.Response
import javax.inject.Inject

class DefaultWeatherDataSource @Inject constructor(private val weatherApi: WeatherApi) :
    RemoteWeatherDataSource {

    override suspend fun fetchWeatherData(queryParam: Map<String, String>): Response<WeatherResponse> {
        return weatherApi.gatWeatherForecast(options = queryParam)
    }
}