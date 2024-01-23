package com.example.android_expandablelayout_recycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_expandablelayout_recycler.databinding.FragmentTest1Binding

class Test1Fragment : Fragment(){
    lateinit var binding: FragmentTest1Binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test1, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    val items = listOf<String>(
        "asdf",
        "asfasd",
        "asdfas"
    )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.el.setOnClickListener {
            binding.el.expand()
        }

        val recyclerView = binding.el.secondLayout.findViewById<RecyclerView>(R.id.rv)
        val adapter = TextAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        adapter.submitList(items)
    }
}