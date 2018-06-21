package com.adnroid.devcuba.messengerproject

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.adnroid.devcuba.messengerproject.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.custom_edit_text.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.editText.custom_title.text = "Text From Activity"
    }
}
