package co.tractionapps.weatherapp.data.source.remote.forecasts.response.weather_response_objects

data class City(
    val coord: Coord,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int,
)