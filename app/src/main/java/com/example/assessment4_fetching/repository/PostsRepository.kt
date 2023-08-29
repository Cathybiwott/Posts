package com.example.assessment4_fetching.repository

import com.example.assessment4_fetching.api.ApiClient
import com.example.assessment4_fetching.api.ApiInterface
import com.example.assessment4_fetching.model.PostsData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostsRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)
    suspend fun getPosts(): Response<List<PostsData>> {
        return withContext(Dispatchers.IO) {
            apiClient.getPosts()

        }

    }
}