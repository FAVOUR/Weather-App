package co.favour.weatherapp.data.source.remote.api

import co.favour.weatherapp.data.Constants.APIKEY
import co.favour.weatherapp.data.source.remote.forecasts.response.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface WeatherApi {

    @GET("forecast")
    suspend fun gatWeatherForecast(
        @QueryMap options: Map<String, String>,
        @Query("appid") apiKey: String = APIKEY,
    ): Response<WeatherResponse>
}