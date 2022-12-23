package co.tractionapps.weatherapp.source.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface WeatherDao {
    @Insert(onConflict = REPLACE)
    fun saveCurrentWeatherCondition(weatherEntity: WeatherEntity)

    @Query("SELECT * FROM weatherEntity")
    fun observeWeather():Flow<List<WeatherEntity>>
}