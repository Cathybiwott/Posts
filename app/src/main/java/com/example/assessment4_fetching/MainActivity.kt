package com.example.assessment4_fetching

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        postViewModel.posts.observe(this) { posts ->
        }

        postViewModel.fetchPosts()
    }
}
