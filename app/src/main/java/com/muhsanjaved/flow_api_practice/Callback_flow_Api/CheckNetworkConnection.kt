package com.muhsanjaved.flow_api_practice.Callback_flow_Api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.muhsanjaved.flow_api_practice.databinding.ActivityCheckNetworkConnectionBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce

class CheckNetworkConnection : AppCompatActivity() {
    private lateinit var binding : ActivityCheckNetworkConnectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckNetworkConnectionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        lifecycleScope.launchWhenStarted {
            checkConnect().collect{
              val check =  when(it){
                    true-> "connnected with internet"
                    false-> "Not connected"
                }
                binding.checkNetworkTextview.text = check
            }
        }

        lifecycleScope.launchWhenStarted {
            binding.username.textChange().debounce(400L).collect{
                Log.d("main", "onCreate: $it")

                binding.checkNetworkTextview.text = it
            }
        }
    }
}