package com.adnroid.devcuba.messengerproject

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.adnroid.devcuba.messengerproject.customview.CustomEditTextViewModel
import com.adnroid.devcuba.messengerproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: CustomEditTextViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(CustomEditTextViewModel::class.java)
        binding.viewModel = viewModel

        binding.setLifecycleOwner(this)
        binding.button.setOnClickListener { viewModel.inputText.value = "Testing LiveData" }
    }

}

