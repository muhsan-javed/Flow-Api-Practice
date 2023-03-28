package com.muhsanjaved.flow_api_practice.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhsanjaved.flow_api_practice.Model.Post
import com.muhsanjaved.flow_api_practice.Reponsitory.PostRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PostViewModel : ViewModel(){

    val responseLiveData: MutableLiveData<List<Post>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            PostRepository.getPost()
                .catch {e->
                    Log.d("main","getPost POstViewModel: ${e.message}")
                }
                .collect{response->
                    responseLiveData.value = response
                }
        }
    }

}