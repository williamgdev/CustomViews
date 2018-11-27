package com.adnroid.devcuba.messengerproject.swipetabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.adnroid.devcuba.messengerproject.R
import com.adnroid.devcuba.messengerproject.databinding.ActivitySwipeTabsBinding
import java.lang.Exception

class SwipeTabsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySwipeTabsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_swipe_tabs)
        binding.viewPager.adapter = SwipeFragmentsPageAdapter(supportFragmentManager)
    }
}

class SwipeFragmentsPageAdapter(supportFragmentManager: FragmentManager): FragmentPagerAdapter(supportFragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> TabPageFragment.newInstance("Tab Page - $position")
            1 -> TabPageFragment.newInstance("Tab Page - $position")
            2 -> TabPageFragment.newInstance("Tab Page - $position")
            3 -> TabPageFragment.newInstance("Tab Page - $position")
            else -> throw Exception("Item not Found on SwipeFragmentsPageAdapter")
        }
    }

    override fun getCount() = 4

    override fun getPageTitle(position: Int) = "Tab Page - $position"
}
