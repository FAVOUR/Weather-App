package co.tractionapps.weatherapp.source.local

import androidx.room.Database

@Database(entities = [WeatherEntity::class], version = 1, exportSchema = true)
abstract class WeatherDb {
    abstract fun weatherDao(): WeatherDao
}