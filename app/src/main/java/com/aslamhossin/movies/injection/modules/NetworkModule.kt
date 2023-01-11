package com.aslamhossin.movies.injection.modules

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.aslamhossin.movies.BuildConfig
import com.aslamhossin.movies.data.remote.MockApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    private val json = Json {
        ignoreUnknownKeys = true
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient().newBuilder()
            .connectTimeout(45, SECONDS)
            .readTimeout(60, SECONDS)
            .writeTimeout(60, SECONDS)
            .addInterceptor(loggingInterceptor)

            .build()
    }

    @ExperimentalSerializationApi
    @Provides
    @Singleton
    fun provideRetrofitClient(
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(
        retrofit: Retrofit
    ): MockApi {
        return retrofit.create(MockApi::class.java)
    }
}
