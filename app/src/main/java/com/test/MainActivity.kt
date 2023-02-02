package com.test

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.databinding.ActivityMainBinding
import com.test.databinding.TestBinding
import kotlinx.coroutines.NonCancellable.start
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity(){
    /*//khởi tạo ViewModel
    private val viewModel: ViewModel by lazy {
        ViewModelProvider(this)[ViewModel::class.java]
    }*/

    /* private lateinit var binding: TestBinding
     private lateinit var videoView: VideoView
     private val recyclerAdapter = ListAdapter()
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         binding = TestBinding.inflate(layoutInflater)
         setContentView(binding.root)
         initGetDataApi()
         lifecycleScope.launchWhenCreated {
             delay(1000L)
             playVideo()
         }
         *//*initAdapter()
        initViewModel()*//*

    }

    private fun playVideo(videoUri: String) {
        videoView = binding.videoView
        //link video
        val uri: Uri = Uri.parse(videoUri)
        videoView.setVideoURI(uri)
        //khởi tạo điều khiển phương tiện chạy video
        val mediaController = MediaController(this)
        mediaController.apply {
            setAnchorView(videoView)
            //setMediaPlayer(videoView)
        }
        videoView.apply {
            setMediaController(mediaController)
            //bắt đầu phát video
            start()
        }
    }

    private fun initGetDataApi() {
        viewModel.getItemToApi()
        lifecycleScope.launchWhenCreated {
            viewModel.item.collect {
                if (it != null) {
                    //binding.tvTitle.text = it.homepage
                    // playVideo(it.homepage)
                    playVideo("https://www.youtube.com/watch?v=BdJKm16Co6M&t=1s")
                }
            }
        }
    }*/
    //khởi tạo databinding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getFragment()
    }
    private fun getFragment(){
        val fragment = ListFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment, fragment).commit()
    }


}