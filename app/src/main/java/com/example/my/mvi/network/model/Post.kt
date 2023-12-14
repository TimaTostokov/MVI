package com.example.my.mvi.network.model

import kotlinx.serialization.Serializable

@Suppress("PLUGIN_IS_NOT_ENABLED")
@Serializable
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)