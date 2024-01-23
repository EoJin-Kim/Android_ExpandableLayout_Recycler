package com.example.android_expandablelayout_recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android_expandablelayout_recycler.databinding.ItemTextBinding

class TextAdapter(
    var onClickInfo: ((item: String) -> Unit)? = null
) : ListAdapter<String, TextAdapter.TextAdapterViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextAdapterViewHolder {
        return TextAdapterViewHolder(
            ItemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onClickInfoListener = onClickInfo,
        )
    }

    override fun onBindViewHolder(holder: TextAdapterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val diffUtil = object: DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class TextAdapterViewHolder(
        private val binding: ItemTextBinding,
        private val onClickInfoListener: ((item: String) -> Unit) ?= null

    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            data: String
        ) {
            binding.tv.text = data

            binding.root.setOnClickListener {
                onClickInfoListener?.invoke(data)
            }
        }
    }
}