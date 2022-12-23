package co.tractionapps.weatherapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WeatherEntity::class], version = 1, exportSchema = true)
abstract class WeatherDb: RoomDatabase(){
    abstract fun weatherDao(): WeatherDao
}