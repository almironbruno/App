package com.bruno.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bruno.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.result.observe(this) {
            val texto: String =  getString(R.string.resultTextView).plus("\n")
            binding.resultTextView.text = texto.plus(it)
        }

        binding.compareButton.setOnClickListener {

            val text1 = binding.text1.getFragment<CustomInput>().getText()
            val text2 = binding.text2.getFragment<CustomInput>().getText()
            mainViewModel.compareStrings(text1,text2)
        }
    }

}