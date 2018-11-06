package com.adnroid.devcuba.messengerproject

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.adnroid.devcuba.messengerproject.databinding.ActivitySchoolBinding
import com.adnroid.devcuba.messengerproject.fragment.ProfessorFragment
import com.adnroid.devcuba.messengerproject.fragment.StudentFragment

class SchoolActivity : AppCompatActivity(), SchoolUserInteraction {

    private lateinit var  binding: ActivitySchoolBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_school)
        binding.userInteraction = this
    }

    override fun launchProfessorFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.contentView, ProfessorFragment.newInstance())
                .commit()
    }

    override fun launchStudentFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.contentView, StudentFragment.newInstance())
                .commit()
    }

}

interface SchoolUserInteraction {
    fun launchProfessorFragment()
    fun launchStudentFragment()
}