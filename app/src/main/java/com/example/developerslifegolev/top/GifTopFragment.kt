package com.example.developerslifegolev.top

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.developerslifegolev.databinding.FragmentGifBinding


class GifTopFragment : Fragment() {
    lateinit var binding: FragmentGifBinding
    lateinit var gifTopInfoViewModel: GifTopInfoViewModel
    lateinit var gifTopInfoItem: GifTopInfoItem
    var gifCacheList: ArrayList<Result> = arrayListOf()
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        gifTopInfoViewModel = ViewModelProvider(requireActivity()).get(GifTopInfoViewModel::class.java)
        binding = FragmentGifBinding.inflate(inflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        if (savedInstanceState == null) {
            gifTopInfoViewModel.request()
        }

        binding.btnNext.setOnClickListener {
            if (position == gifCacheList.size){
                gifTopInfoViewModel.request()
            }
            else{
                loadImage(gifCacheList[position].gifURL)
                binding.textViewGif.text = gifCacheList[position].description
                position++
            }

        }

        binding.btnBack.setOnClickListener {
            if (gifCacheList.size == 1 || position == 1){
                Toast.makeText(getActivity(), "В кэше пусто!", Toast.LENGTH_SHORT).show()
            }else{
                loadImage(gifCacheList[position-2].gifURL)
                binding.textViewGif.text = gifCacheList[position-2].description
                position--
            }
        }
    }

    override fun onStart() {
        super.onStart()
        gifTopInfoViewModel.itemGifTopInfo.observe(activity as LifecycleOwner, Observer {
            gifTopInfoItem = it
            val listResult = gifTopInfoItem.result
            gifCacheList.addAll(listResult)
            position++
            loadImage(listResult[0].gifURL)
            binding.textViewGif.text = listResult[0].description
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = GifTopFragment()
    }

    private fun loadImage(gifURL: String){
        if (getActivity() == null) {
            return
        }
        Glide.with(this)
            .asGif()
            .load(gifURL)
            .into(binding.imageViewGif)
    }

}