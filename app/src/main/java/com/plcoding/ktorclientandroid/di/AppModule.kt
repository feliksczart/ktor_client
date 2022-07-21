package com.plcoding.ktorclientandroid.di

import com.plcoding.ktorclientandroid.data.remote.PostsApi
import com.plcoding.ktorclientandroid.data.repository.PostsRepositoryImp
import com.plcoding.ktorclientandroid.domain.repository.PostsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideKtorClient(): HttpClient {
        return HttpClient(Android) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }
    }

    @Provides
    @Singleton
    fun providePostsApi(client: HttpClient): PostsApi {
        return PostsApi(client)
    }

    @Provides
    @Singleton
    fun providePostsRepository(api: PostsApi): PostsRepository {
        return PostsRepositoryImp(api)
    }
}