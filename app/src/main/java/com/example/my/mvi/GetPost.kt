package com.example.my.mvi

import com.example.my.mvi.network.PostApi
import com.example.my.mvi.network.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPost(private val postApi: PostApi) {

    fun execute(): Flow<DataState<List<Post>>> {
        return flow {
            emit(DataState.Loading(true))
            try {
                val post = postApi.getPost()
                emit(DataState.Success(post))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(DataState.Error(UIComponent.Toast(e.message ?: "Unknown error")))
            }finally {
                emit(DataState.Loading(false))
            }
        }
    }

}