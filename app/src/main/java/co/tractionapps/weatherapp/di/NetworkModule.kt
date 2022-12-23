package co.tractionapps.weatherapp.di

import co.tractionapps.weatherapp.data.source.remote.api.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val HTTP_CACHE_SIZE = 1024 * 1024 * 1024L
    private const val CONNECTION_TIMEOUT_SECONDS = 600L

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(CONNECTION_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun okhttpLogger(): HttpLoggingInterceptor {

        val interceptor = HttpLoggingInterceptor()

        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, httpBaseUrl: String): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(httpBaseUrl)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiClient(retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }
}