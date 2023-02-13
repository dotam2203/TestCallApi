package com.test

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.test.databinding.ActivityMainBinding
import com.test.fragment.DatePickerCustomFragment
import com.test.fragment.ListFragment
import java.util.ResourceBundle.Control.getControl

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
        getFragment(ListFragment(),R.id.fragment)
        getOnclickCalendar()
    }

    private fun getOnclickCalendar() {
        binding.imbCalendar.setOnClickListener {
            getFragment(DatePickerCustomFragment(),R.id.fragment)
        }
        binding.imbBack.setOnClickListener {
            getFragment(ListFragment(),R.id.fragment)
        }
    }
    private fun getFragment(fragment: Fragment, id: Int){
        supportFragmentManager.beginTransaction().replace(id, fragment).commit()
    }


}