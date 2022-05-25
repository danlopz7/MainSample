package com.example.homework5beta1.ui.itemsList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Photos
import com.example.homework5beta1.databinding.ItemsPostBinding

//abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder>
class ItemsPostAdapter(private val onClickListener: OnClickListener) : ListAdapter<Photos, ItemsPostAdapter.PostsViewHolder>(DiffCallback), View.OnClickListener {

    class PostsViewHolder(private var binding: ItemsPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Photos) {
            binding.photo = post
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(
            ItemsPostBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(currentItem)
            //onClick()
        }
        holder.bind(currentItem)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Photos>() {
        override fun areItemsTheSame(oldItem: Photos, newItem: Photos): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Photos, newItem: Photos): Boolean {
            return oldItem.title == newItem.title
        }
    }

    class OnClickListener(val clickListener: (photo:Photos) -> Unit){
        fun onClick(photo:Photos) = clickListener(photo)
    }

    override fun onClick(v: View?) {
        val clickListener: (photo:Photos) -> Unit
    }
}