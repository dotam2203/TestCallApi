package com.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {
    private val listRepository = ListRepository()
   /* private val _list = MutableStateFlow(emptyList<ListModel>())
    val list: StateFlow<List<ListModel>> = _list*/
    private val _item: MutableStateFlow<ListModel?> = MutableStateFlow(null)
    val item: StateFlow<ListModel?> = _item

    fun getListApi(){
        viewModelScope.launch {
            listRepository.getList("e13cc716899ae5b7470d71870624e435").collect{
                if(it.isSuccessful)
                    _item.value = it.body()
            }
        }
    }
}