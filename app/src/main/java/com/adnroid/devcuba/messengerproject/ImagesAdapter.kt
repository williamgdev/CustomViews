package com.adnroid.devcuba.messengerproject

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adnroid.devcuba.messengerproject.databinding.ListRecyclerImageBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ImagesAdapter(val images: MutableList<String>) : RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ListRecyclerImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun getItemCount(): Int = images.size


    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(images[position])
    }

    class ImageViewHolder(val binding: ListRecyclerImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imageUrl: String) {
            binding.imageUrl = imageUrl
        }

    }
    companion object {

        @BindingAdapter(value = ["imageUrl"], requireAll = true)
        @JvmStatic
        fun setProductImage(imageView: ImageView, imageUrl: String?) {
            Glide.with(imageView.context)
                    .asBitmap()
                    .load(imageUrl)
                    .into(imageView)

        }
    }
}
