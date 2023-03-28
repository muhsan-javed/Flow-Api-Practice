package com.muhsanjaved.flow_api_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhsanjaved.flow_api_practice.Adapter.PostAdapter
import com.muhsanjaved.flow_api_practice.Model.Post
import com.muhsanjaved.flow_api_practice.ViewModel.PostViewModel
import com.muhsanjaved.flow_api_practice.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var postAdapter: PostAdapter
    lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Kotlin Flow - flow {} builder block
      /*  runBlocking {
            getData().catch {e->
                Log.d("main", "onCreate $e")
            }
            getData().collect { data->
                Log.d("main","OnCreate: $data")
            }
        }*/

        // Kotlin flowOf() method-
//        val data = flowOf(1,3,5,45) //.flowOn(Dispatchers.IO)

         // Kotlin Flow - asFlow( ) method
       /* val data = listOf(1,2,3,4,5,6).asFlow().flowOn(Dispatchers.IO) //.flowOn(Dispatchers.IO)

        runBlocking {
            data.collect{
                Log.d("main","OnCreate: $it")
            }
        }
*/
        // Kotlin Flow - map { } operator

       /* val data = flowOf(1,2,3,4,5,6).flowOn(Dispatchers.IO)
        runBlocking {
            data.map { value ->
                value * value
            }.collect {
                Log.d("main","OnCreate: $it")
            }
        }*/

        // Kotlin Flow - filter { } operator
       /* val data = flowOf(1,2,3,4,5,6,7,8,9,10).flowOn(Dispatchers.IO)
        runBlocking {
            data.filter { value->
                value%2 == 0

            }.collect {
                Log.d("main","OnCreate: $it")
            }
        }*/


        postAdapter = PostAdapter(this, ArrayList())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }

        postViewModel = ViewModelProvider(this)[PostViewModel::class.java]
        postViewModel.getPost()
        postViewModel.responseLiveData.observe(this, Observer {
            postAdapter.setData(it as ArrayList<Post>)
            binding.progress.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
        })

    }

    // Kotlin Flow - flow {} builder block
   /* fun getData() : Flow<Int> = flow {
        for (i in 1..5)
        {
            delay(1000)
            emit(i)
        }
    }.flowOn(Dispatchers.IO)*/



}