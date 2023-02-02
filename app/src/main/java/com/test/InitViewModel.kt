package com.test

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

abstract class InitViewModel : Fragment() {
    //khởi tạo ViewModel
    val viewModel: ViewModel by lazy {
        ViewModelProvider(this)[ViewModel::class.java]
    }
}