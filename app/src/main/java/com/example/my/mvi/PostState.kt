package com.example.my.mvi

import com.example.my.mvi.network.model.Post

data class PostState(
    val progressBar: Boolean = false,
    val posts: List<Post> = emptyList(),
) {}