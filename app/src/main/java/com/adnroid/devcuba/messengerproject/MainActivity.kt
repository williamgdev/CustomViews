package com.adnroid.devcuba.messengerproject

import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.adnroid.devcuba.messengerproject.customview.CustomEditTextViewModel
import com.adnroid.devcuba.messengerproject.databinding.ActivityMainBinding
import com.adnroid.devcuba.messengerproject.swipetabs.SwipeTabsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: CustomEditTextViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(CustomEditTextViewModel::class.java)
        viewModel.inputText.value = "First Text"
        binding.viewModel = viewModel
        binding.userInteraction = object : MainUserInteraction {
            override fun gotoRecyclerExample() {
                launchRecyclerFragment()
            }

            override fun gotoSchoolExample() {
                launchSchoolActivity()
            }

            override fun gotoSwipeExample() {
                launchSwipeActivity()
            }

        }
        binding.setLifecycleOwner(this)
//        binding.button.setOnClickListener { viewModel.inputText.value = "Testing LiveData" }
    }
    private fun launchSwipeActivity() {
        startActivity(Intent(this, SwipeTabsActivity::class.java))
    }

    private fun launchSchoolActivity() {
        startActivity(Intent(this, SchoolActivity::class.java))
    }

    private fun launchRecyclerFragment() {
        startActivity(Intent(this, RecyclerActivity::class.java))
    }

    interface MainUserInteraction {
        fun gotoSchoolExample()
        fun gotoSwipeExample()
        fun gotoRecyclerExample()
    }

}

