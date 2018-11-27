package com.adnroid.devcuba.messengerproject.swipetabs

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.adnroid.devcuba.messengerproject.R
import com.adnroid.devcuba.messengerproject.databinding.ActivitySwipeTabsBinding
import com.adnroid.devcuba.messengerproject.databinding.ItemTabLayoutBinding
import kotlinx.android.synthetic.main.activity_swipe_tabs.*
import java.lang.Exception

class SwipeTabsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySwipeTabsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_swipe_tabs)
        val swipeFragmentsPageAdapter = SwipeFragmentsPageAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = swipeFragmentsPageAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        for (i in 0 until binding.tabLayout.tabCount) {
            val tab = tabLayout.getTabAt(i)
            tab?.customView = swipeFragmentsPageAdapter.getTabView(i)
        }
    }
}

class SwipeFragmentsPageAdapter(val context: Context, supportFragmentManager: FragmentManager): FragmentPagerAdapter(supportFragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> TabPageFragment.newInstance("Tab Page - $position")
            1 -> TabPageFragment.newInstance("Tab Page - $position")
            2 -> TabPageFragment.newInstance("Tab Page - $position")
            3 -> TabPageFragment.newInstance("Tab Page - $position")
            else -> throw Exception("Item not Found on SwipeFragmentsPageAdapter")
        }
    }

    fun getTabView(position: Int): View {
        val binding = ItemTabLayoutBinding.inflate(LayoutInflater.from(context))
        return binding.root
    }

    override fun getCount() = 4

    override fun getPageTitle(position: Int) = "Tab Page - $position"
}
