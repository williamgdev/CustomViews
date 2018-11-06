package com.adnroid.devcuba.messengerproject.fragment

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class ProfessorViewModel : ViewModel() {
    val listOfProfessor = MutableLiveData<List<ProfessorEntity>>()

    fun loadData() {
        listOfProfessor.postValue(listOf(
                ProfessorEntity("Name 1", "Last Name 1", "23"),
                ProfessorEntity("Name 2", "Last Name 2", "23"),
                ProfessorEntity("Name 3", "Last Name 3", "23"),
                ProfessorEntity("Name 4", "Last Name 4", "23"),
                ProfessorEntity("Name 5", "Last Name 5", "23")
                )
        )
    }
}

data class ProfessorEntity(val name:String, val lastName:String, val age:String)
