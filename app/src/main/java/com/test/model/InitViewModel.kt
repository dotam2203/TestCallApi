package com.test.model

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.test.ViewModel

abstract class InitViewModel : Fragment() {
    //khởi tạo ViewModel
    val viewModel: ViewModel by lazy {
        ViewModelProvider(this)[ViewModel::class.java]
    }
}