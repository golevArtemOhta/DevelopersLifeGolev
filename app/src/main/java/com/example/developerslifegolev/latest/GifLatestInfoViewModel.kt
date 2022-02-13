package com.example.developerslifegolev.latest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.developerslifegolev.random.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class GifLatestInfoViewModel: ViewModel() {
    val itemGifLatestInfo = MutableLiveData<GifLatestInfoItem>()
    private val api = RetrofitFactory.new()
    private var job: Job? = null

    fun request() {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            val gifLatestInfo = api.getLatestGif()
            itemGifLatestInfo.postValue(gifLatestInfo)
        }

    }

}