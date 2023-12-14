package com.example.my.mvi.network

import com.example.my.mvi.network.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface PostApi {

    suspend fun getPost(): List<Post>

    companion object{
        private val httpClient = HttpClient(Android){
            install(ContentNegotiation){
                json(
                    Json{
                        this.ignoreUnknownKeys = true
                    }
                )
            }
        }

        fun providePostApi(): PostApi = PostApiImpl(httpClient)
    }

}