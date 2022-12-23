package co.favour.weatherapp.di

import android.content.Context
import androidx.room.Room
import co.favour.weatherapp.data.source.local.WeatherDao
import co.favour.weatherapp.data.source.local.WeatherDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context): WeatherDb {
        return Room.databaseBuilder(
            context,
            WeatherDb::class.java, "forecast_db"
        ).build()
    }

    @Provides
    fun provideWeatherDao(weatherDb: WeatherDb): WeatherDao {
        return weatherDb.weatherDao()
    }

}