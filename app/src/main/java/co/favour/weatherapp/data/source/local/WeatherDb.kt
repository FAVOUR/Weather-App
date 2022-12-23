package co.favour.weatherapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import co.favour.weatherapp.data.source.local.WeatherDao

@Database(entities = [WeatherEntity::class], version = 1, exportSchema = true)
abstract class WeatherDb : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}