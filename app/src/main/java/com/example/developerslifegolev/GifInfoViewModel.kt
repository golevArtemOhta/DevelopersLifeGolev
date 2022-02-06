package com.example.developerslifegolev

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class GifInfoViewModel: ViewModel() {
    val itemGifInfo = MutableLiveData<GifInfoItem>()
    private val api = RetrofitFactory.new(ApiRequest::class.java)
    private var job: Job? = null

    fun request() {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            val gifInfo = api.getGif()
            itemGifInfo.postValue(gifInfo)
        }

    }

}