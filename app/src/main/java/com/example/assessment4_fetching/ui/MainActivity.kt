package com.example.assessment4_fetching.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assessment4_fetching.databinding.ActivityMainBinding
import com.example.assessment4_fetching.viewmodel.PostsViewModel

class MainActivity : AppCompatActivity() {
    val postsViewModel: PostsViewModel by viewModels()
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


    }
    override fun onResume() {
        super.onResume()
        postsViewModel.getAllPosts()
        postsViewModel.postsLiveData.observe(this, Observer { postsList ->
            Toast.makeText(
                baseContext,
                "the ${postsList?.size} posts have been fetched",
                Toast.LENGTH_SHORT
            ).show()
            binding.rvPosts.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvPosts.adapter= PostsRvAdapter(postsList)
        })
        postsViewModel.errorLiveData.observe(this,Observer{error->
            Toast.makeText(baseContext,error, Toast.LENGTH_LONG).show()
        })
    }
}
