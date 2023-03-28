package com.muhsanjaved.flow_api_practice.Reponsitory

import com.muhsanjaved.flow_api_practice.Model.Post
import com.muhsanjaved.flow_api_practice.Network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class PostRepository {

    companion object{
        fun getPost(): Flow<List<Post>> = flow {
            val response = RetrofitBuilder.api.getPost()
            emit(response)
        }.flowOn(Dispatchers.IO)
    }
}