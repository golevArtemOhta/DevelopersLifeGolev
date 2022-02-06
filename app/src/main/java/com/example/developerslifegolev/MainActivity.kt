package com.example.developerslifegolev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.developerslifegolev.databinding.ActivityMainBinding
import com.example.developerslifegolev.hot.GifHotFragment
import com.example.developerslifegolev.latest.GifLatestFragment
import com.example.developerslifegolev.random.GifFragment
import com.example.developerslifegolev.top.GifTopFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            openFragment(GifFragment.newInstance(), R.id.fragment)
        }


        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            // get the radio group checked radio button
            when (checkedId){
                R.id.radioButtonRandom ->{
                    openFragment(GifFragment.newInstance(), R.id.fragment);
                    Toast.makeText(this, "Random", Toast.LENGTH_SHORT).show();
                }
                R.id.radioButtonLatest ->{
                    openFragment(GifLatestFragment.newInstance(), R.id.fragment);
                    Toast.makeText(this, "Latest", Toast.LENGTH_SHORT).show();
                }
                R.id.radioButtonHot ->{
                    openFragment(GifHotFragment.newInstance(), R.id.fragment);
                    Toast.makeText(this, "Hot", Toast.LENGTH_SHORT).show();
                }

                R.id.radioButtonTop ->{
                    openFragment(GifTopFragment.newInstance(), R.id.fragment);
                    Toast.makeText(this, "Top", Toast.LENGTH_SHORT).show();
                }

            }
        }


    }

    private fun openFragment(fragment: Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, fragment)
            .commit()
    }
}