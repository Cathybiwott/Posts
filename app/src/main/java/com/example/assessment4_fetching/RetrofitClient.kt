package com.example.assessment4_fetching

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    interface RetrofitClient {
        companion object {
            private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

            fun getClient(): Retrofit {
                return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
        }
    }
}