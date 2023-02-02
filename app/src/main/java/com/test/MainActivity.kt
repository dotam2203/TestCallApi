package com.test

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.databinding.ActivityMainBinding
import com.test.databinding.TestBinding
import kotlinx.coroutines.NonCancellable.start
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    //khởi tạo ViewModel
    private val viewModel: ViewModel by lazy {
        ViewModelProvider(this)[ViewModel::class.java]
    }

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
    //khởi tạo adapter
    private val recyclerAdapter = ListAdapter()
    //khởi tạo GenresModel
    private val genres = ArrayList<Genres>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        initViewModel()
    }

    private fun initViewModel() {
        //gọi api
        viewModel.getItemToApi()
        //couroutines scope
        lifecycleScope.launchWhenStarted {
            //lấy biến đã khởi tạo bên viewmodel
            viewModel.list.collect {
                //kiểu tra danh sách rỗng hay không
                if(it.isNotEmpty()){
                    //thêm danh sách vừa lấy được vào list khai báo ở adapter
                    genres.addAll(it)
                    recyclerAdapter.apply {
                        genres.addAll(it)
                        //reload lại danh sách
                        notifyDataSetChanged()
                    }
                }
                else return@collect
            }
        }
    }
    //khởi tạo recyclerview adapter hiển thị lên UI
    private fun initAdapter() {
        binding.apply {
            rvVideo.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = recyclerAdapter
            }
        }
    }
}