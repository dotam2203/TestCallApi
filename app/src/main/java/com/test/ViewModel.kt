package com.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.repository.ListRepository
import com.test.repository.StaffRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {
    //khởi tạo
    private val listRepository = ListRepository()
    //khởi tạo danh sách rỗng với MutableStateFlow
    private val _list = MutableStateFlow(emptyList<Genres>())
    //khởi tạo gán giá trị cho _list khi list lấy được giá trị khi dùng coroutines ở MainActivity
    val list: StateFlow<List<Genres>> = _list

    fun getItemToApi(){
        viewModelScope.launch {
            listRepository.getShowItem("e13cc716899ae5b7470d71870624e435").collect{
                //check call api thành công
                if(it.isSuccessful)
                    //lấy được danh sách Genres
                    _list.value = it.body()?.genres!!
            }
        }
    }
}