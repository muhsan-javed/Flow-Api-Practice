package com.muhsanjaved.flow_api_practice.Network

import com.muhsanjaved.flow_api_practice.Model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPost() : List<Post>


}