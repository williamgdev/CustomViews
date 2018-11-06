package com.adnroid.devcuba.messengerproject.fragment

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;

class StudentViewModel : ViewModel() {
    val listOfStudent = MutableLiveData<List<StudentEntity>>()

    fun loadData() {
        listOfStudent.postValue(listOf(
                StudentEntity("Name 1", "Last Name 1", "23"),
                StudentEntity("Name 2", "Last Name 2", "23"),
                StudentEntity("Name 3", "Last Name 3", "23"),
                StudentEntity("Name 4", "Last Name 4", "23"),
                StudentEntity("Name 5", "Last Name 5", "23"))
        )
    }
}

data class StudentEntity(val name:String, val lastName:String, val age:String)
