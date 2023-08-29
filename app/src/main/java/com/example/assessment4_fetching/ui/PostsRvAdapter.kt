package com.example.assessment4_fetching.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment4_fetching.databinding.PostsListItemBinding
import com.example.assessment4_fetching.model.PostsData

class PostsRvAdapter (var posts:List<PostsData>) : RecyclerView.Adapter<PostsRvAdapter.PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding=PostsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPosts=posts.get(position)
        val binding=holder.binding
        binding.tvId.text=currentPosts.id.toString()
        binding.tvUserId.text=currentPosts.userId.toString()
        binding.tvBody.text=currentPosts.body
        binding.tvTitle.text=currentPosts.body

    }

    override fun getItemCount(): Int {
        return posts.size

    }

    class PostViewHolder(var binding: PostsListItemBinding):RecyclerView.ViewHolder(binding.root)
}