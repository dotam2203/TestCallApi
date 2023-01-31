package com.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.databinding.ActivityMainBinding
import com.test.databinding.TestBinding
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    var listModel = ListModel()
    private val viewModel: ViewModel by lazy {
        ViewModelProvider(this)[ViewModel::class.java]
    }
    //private lateinit var binding: ActivityMainBinding
    private lateinit var binding: TestBinding
    private val recyclerAdapter = ListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        binding = TestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initGetDataApi()
        /*initAdapter()
        initViewModel()*/
    }

    private fun initGetDataApi() {
        viewModel.getListApi()
        lifecycleScope.launchWhenCreated {
            viewModel.item.collect {
                if (it != null) {
                    binding.tvTT.text = listModel.overview
                }
            }
        }
    }

    /*private fun initViewModel() {
        viewModel.getListApi()
        lifecycleScope.launchWhenStarted {
            viewModel.item.collect {
                if (it != null) {
                    recyclerAdapter.items.addAll(it.genres)
                }
            }
        }
    }

    private fun initAdapter() {
        binding.apply {
            rvVideo.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = recyclerAdapter
            }
        }
    }*/
}