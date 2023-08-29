package com.example.assessment4_fetching.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessment4_fetching.model.PostsData
import com.example.assessment4_fetching.repository.PostsRepository
import kotlinx.coroutines.launch

class PostsViewModel: ViewModel() {
    val postsRepository = PostsRepository()
    val postsLiveData = MutableLiveData<List<PostsData>>()
    var errorLiveData = MutableLiveData<String>()
    fun getAllPosts() {
        viewModelScope.launch {
            val response = postsRepository.getPosts()
            if (response.isSuccessful) {
                val postsData = response.body() ?: emptyList()
                postsLiveData.postValue(postsData)
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}