package com.muhsanjaved.flow_api_practice.CounterApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.muhsanjaved.flow_api_practice.databinding.ActivityStateFlowApiCounterAppBinding
import kotlinx.coroutines.flow.collect

class StateFlowApiCounterApp : AppCompatActivity() {

    private lateinit var binding: ActivityStateFlowApiCounterAppBinding

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStateFlowApiCounterAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        counterResult()

    }

    private fun counterResult() {
       lifecycleScope.launchWhenStarted {
           mainViewModel.counter.collect{counter->
                binding.tvCounterTxt.text = counter.toString()
           }
       }
    }

    private fun init(){
        binding.btnAddition.setOnClickListener {
            mainViewModel.incrementState()
        }
        binding.btnSubtraction.setOnClickListener {
            mainViewModel.decrementState()
        }
    }
}