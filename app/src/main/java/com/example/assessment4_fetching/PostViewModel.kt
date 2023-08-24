package com.example.assessment4_fetching

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val apiService = retrofit.create(PostApiService::class.java)
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = _posts

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val response = apiService.getPosts()
                _posts.value = response
            } catch (e: Exception) {
            }
        }
    }

}