package co.tractionapps.weatherapp.di

import co.tractionapps.weatherapp.data.source.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindWeatherRepository(defaultWeatherRepository: WeatherRepository): WeatherRepository
}