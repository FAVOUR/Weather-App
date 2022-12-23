package co.tractionapps.weatherapp.data

import retrofit2.http.Query

object Constants {
// For temperature in Fahrenheit and wind speed in miles/hour, use units=imperial
// For temperature in Celsius and wind speed in meter/sec, use units=metric
    const val METRIC = "metric"
    const val DEFAULT_COUNTRY = "Lagos"
    const val APIKEY = "ab0c384f4b0922aa22626fde4533e524" // move this to gradle file
    const val SECONDS_IN_A_DAY = 86400L
    const val BASE_API =  "api.openweathermap.org/data/2.5/"

    //Keys
    const val API_KEY = "appid"
    const val COUNTRY_KEY = "q"
    const val UNITS_KEY = "units"
}