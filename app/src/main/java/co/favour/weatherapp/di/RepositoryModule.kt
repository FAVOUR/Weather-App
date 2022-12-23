package co.favour.weatherapp.di

import co.favour.weatherapp.data.source.repository.DefaultWeatherRepo
import co.favour.weatherapp.data.source.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindWeatherRepository(defaultWeatherRepository: DefaultWeatherRepo): WeatherRepository
}