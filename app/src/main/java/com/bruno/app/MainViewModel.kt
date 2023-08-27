package com.bruno.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val compareModel: CompareModel = CompareModel()
    val result : LiveData<String> get() = _result
    private var _result = MutableLiveData<String>("")

    fun compareStrings(string1: String, string2: String) {
        _result.value = this.compareModel.compareStrings(string1,string2)
    }

}