package com.example.developerslifegolev

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.developerslifegolev.databinding.FragmentGifBinding


class GifFragment : Fragment() {
    lateinit var binding: FragmentGifBinding
    lateinit var gifInfoViewModel: GifInfoViewModel
    lateinit var gifInfoItem: GifInfoItem
    var gifCacheList: ArrayList<GifInfoItem> = arrayListOf()
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        gifInfoViewModel = ViewModelProvider(requireActivity()).get(GifInfoViewModel::class.java)
        binding = FragmentGifBinding.inflate(inflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        if (savedInstanceState == null) {
            gifInfoViewModel.request()
        }

        binding.btnNext.setOnClickListener {
            if (position == gifCacheList.size){
                gifInfoViewModel.request()
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
        gifInfoViewModel.itemGifInfo.observe(activity as LifecycleOwner, Observer {
            gifInfoItem = it
            val gifURL = gifInfoItem.gifURL
            gifCacheList.add(gifInfoItem)
            position++
            loadImage(gifURL)
            binding.textViewGif.text = gifInfoItem.description
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = GifFragment()
    }

    private fun loadImage(gifURL: String){
        Glide.with(this)
            .asGif()
            .load(gifURL)
            .into(binding.imageViewGif);
    }

}