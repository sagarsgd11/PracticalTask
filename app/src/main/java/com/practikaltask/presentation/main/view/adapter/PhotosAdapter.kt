package com.practikaltask.presentation.main.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practikaltask.databinding.ItemPhotosBinding
import com.practikaltask.presentation.main.model.PhotosData

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    private var photoList: ArrayList<PhotosData> = arrayListOf()

    inner class ViewHolder(private val binding: ItemPhotosBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photosData: PhotosData) {
            binding.titleText.text = photosData.title ?: ""
            Glide.with(binding.photoImage).load(photosData.thumbnailUrl).into(binding.photoImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPhotosBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photoList[position])
    }

    fun appendData(it: List<PhotosData>) {
        photoList.addAll(it)
        notifyDataSetChanged()
    }
}