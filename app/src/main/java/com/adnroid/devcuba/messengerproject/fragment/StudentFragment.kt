package com.adnroid.devcuba.messengerproject.fragment

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adnroid.devcuba.messengerproject.databinding.ListItemsStudentBinding

import com.adnroid.devcuba.messengerproject.databinding.StudentFragmentBinding

class StudentFragment : Fragment() {

    companion object {
        fun newInstance() = StudentFragment()
    }

    private lateinit var viewModel: StudentViewModel
    private lateinit var binding: StudentFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = StudentFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StudentViewModel::class.java)
        viewModel.listOfStudent.observe(this, Observer {
            binding.recycler.swapAdapter(StudentAdapter(it), true)
        })
        viewModel.loadData()
    }

}

class StudentAdapter(val list: List<StudentEntity>?) : RecyclerView.Adapter<StudentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): StudentViewHolder {
        val binding = ListItemsStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun getItemCount() = list?.size ?: 0

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.binding.studentEntity = list?.get(position)
    }

}

class StudentViewHolder(val binding: ListItemsStudentBinding): RecyclerView.ViewHolder(binding.root)
