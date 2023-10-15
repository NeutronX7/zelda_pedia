package com.example.zelda_pedia.io

import com.example.zelda_pedia.models.games.Game
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface API {

    @GET("games")
    suspend fun getGames() : Response<Game>

    companion object {
        private const val BASE_URL = "https://zelda.fanapis.com/api/"

        fun getUrl() : API{
            val interceptor = HttpLoggingInterceptor()
            val client = OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(API::class.java)
        }
    }

}