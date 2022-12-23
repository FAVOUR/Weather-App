package co.tractionapps.weatherapp.di

import android.content.Context
import co.tractionapps.weatherapp.data.source.remote.forecasts.DefaultWeatherDataSource
import co.tractionapps.weatherapp.data.source.remote.forecasts.RemoteWeatherDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun provideContext(@ApplicationContext context: Context): Context

    @Binds
    abstract fun bindRemoteWeatherDataSource(defaultRemoteWeatherDataSource: DefaultWeatherDataSource): RemoteWeatherDataSource

}