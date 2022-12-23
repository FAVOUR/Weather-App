package co.tractionapps.weatherapp.ui.model

import co.tractionapps.weatherapp.model.WeatherData

//Model
class WeatherReport(val timeInMills: Long,
                    val location: String,
                    val country: String,
                    val temprature: Double,
                    val feelsLike: Double,
                    val minTemprature: Double,
                    val maxTemp: Double,
                    val humidity: Double,
                    val uvIndex: String,
                    val windSpeed: Double,
                    val weatherDescription: String,
                    val weatherCondition: String,
                    val icon:String,
                    val metric:String)

//Map
 fun WeatherData.toWeatherReport():WeatherReport{
     return WeatherReport(
         timeInMills = timeInMills,
         location = location ,
         country = country,
         temprature =temprature,
         feelsLike = feelsLike,
         minTemprature = minTemprature,
         maxTemp = maxTemp,
         humidity = humidity,
         uvIndex = uvIndex,
         windSpeed = windSpeed,
         weatherDescription = weatherDescription,
         weatherCondition = weatherCondition,
         metric = metric,
         icon = icon)
 }