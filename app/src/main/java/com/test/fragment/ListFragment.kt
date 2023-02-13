package com.test.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.Genres
import com.test.adapter.ListAdapter
import com.test.databinding.ListFragmentBinding
import com.test.model.InitViewModel

class ListFragment : InitViewModel() {
    private lateinit var binding: ListFragmentBinding
    //khởi tạo adapter
    private val recyclerAdapter by lazy {
        ListAdapter()
    }

    //khởi tạo GenresModel
    private val genres = ArrayList<Genres>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListFragmentBinding.inflate(layoutInflater)
        initAdapter()
        initViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initViewModel() {
        //gọi api
        viewModel.getItemToApi()
        //couroutines scope
        lifecycleScope.launchWhenStarted {
            //lấy biến đã khởi tạo bên viewmodel
            viewModel.list.collect {
                //kiểu tra danh sách rỗng hay không
                if (it.isNotEmpty()) {
                    //thêm danh sách vừa lấy được vào list khai báo ở adapter
                    genres.addAll(it)
                    recyclerAdapter.apply {
                        genres.addAll(it)
                        //reload lại danh sách
                        //notifyDataSetChanged()
                        recyclerAdapter.diffGenres.submitList(it)
                    }
                } else return@collect
            }
        }
    }

    //khởi tạo recyclerview adapter hiển thị lên UI
    private fun initAdapter() {
        binding.apply {
            rvVideo.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = recyclerAdapter
            }
        }
    }
}