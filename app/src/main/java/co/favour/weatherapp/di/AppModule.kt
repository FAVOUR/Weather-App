package co.favour.weatherapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAppScope() = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    @Provides
    fun provideIODispatcher() = Dispatchers.IO
}