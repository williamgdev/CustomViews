package com.adnroid.devcuba.messengerproject.fragment

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adnroid.devcuba.messengerproject.databinding.ListItemsProfessorBinding

import com.adnroid.devcuba.messengerproject.databinding.ProfesorFragmentBinding

class ProfessorFragment : Fragment() {

    companion object {
        fun newInstance() = ProfessorFragment()
    }

    private lateinit var viewModel: ProfessorViewModel
    private lateinit var binding: ProfesorFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = ProfesorFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProfessorViewModel::class.java)
        viewModel.listOfProfessor.observe(this, Observer {
            binding.recycler.swapAdapter(ProfessorAdapter(it), true)
        })
        viewModel.loadData()
    }

}

class ProfessorAdapter(val list: List<ProfessorEntity>?) : RecyclerView.Adapter<ProfessorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ProfessorViewHolder {
        val binding = ListItemsProfessorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProfessorViewHolder(binding)
    }

    override fun getItemCount() = list?.size ?: 0

    override fun onBindViewHolder(holder: ProfessorViewHolder, position: Int) {
        holder.binding.professorEntity = list?.get(position)
    }

}

class ProfessorViewHolder(val binding: ListItemsProfessorBinding): RecyclerView.ViewHolder(binding.root)

