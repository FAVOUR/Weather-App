package co.tractionapps.weatherapp.source.remote.api

import co.tractionapps.weatherapp.data.Constants.API_KEY
import co.tractionapps.weatherapp.source.remote.forcasts.response.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface WeatherApi {

    @GET("/forecast")
    suspend fun forCastBasedOnCountry(
        @QueryMap options: Map<String, String>,
        @Query("appid") apiKey: String = API_KEY
//        @Query("q") country: String = DEFAULT_COUNTRY,
//        @Query("units") unit: String = UNIT
    ): Response<WeatherResponse>
}