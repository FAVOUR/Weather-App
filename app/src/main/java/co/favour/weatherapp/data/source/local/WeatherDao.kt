package co.favour.weatherapp.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import co.favour.weatherapp.data.source.local.WeatherEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {
    @Insert(onConflict = REPLACE)
    fun saveCurrentWeatherCondition(weatherEntity: WeatherEntity)

    @Query("SELECT * FROM weatherEntity")
    fun observeWeather(): Flow<List<WeatherEntity>>

    @Query("DELETE FROM weatherEntity")
    fun deleteAllData()
}