package com.example.assessment4_fetching.api

import com.example.assessment4_fetching.model.PostsData
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
    suspend fun getPosts(): Response<List<PostsData>>
}