package com.adnroid.devcuba.messengerproject

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import com.adnroid.devcuba.messengerproject.customview.CustomEditTextViewModel
import com.adnroid.devcuba.messengerproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: CustomEditTextViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(CustomEditTextViewModel::class.java)
        viewModel.inputText.value = "First Text"
        binding.viewModel = viewModel

        binding.setLifecycleOwner(this)
        binding.button.setOnClickListener { viewModel.inputText.value = "Testing LiveData" }
        /**
         * The code bellow is replaced by the '=' in the xml layout
         * Just write instead of
         * @{viewModel.inputText} do
         * @={viewModel.inputText}
         */
//        binding.editText.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
////                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
////                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                viewModel.inputText.value = s.toString()
//            }
//        })
    }

}

