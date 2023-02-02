package com.example.android.marsphotos.other

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.marsphotos.databinding.MarsPhotoItemBinding
import com.example.android.marsphotos.network.MarsPhoto

class MarsPhotoItemAdapter(
    var photos: List<MarsPhoto>,
    private val context: Context
) : RecyclerView.Adapter<MarsPhotoItemAdapter.MarsPhotoItemViewHolder>() {

    class MarsPhotoItemViewHolder(
        val binding: MarsPhotoItemBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotoItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MarsPhotoItemBinding.inflate(inflater, parent, false)
        return MarsPhotoItemViewHolder(binding)
    }

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: MarsPhotoItemViewHolder, position: Int) {
        val marsPhoto = photos[position]
        with(holder.binding) {
            tvMarsPhotoId.text = marsPhoto.id
            Glide.with(context).load(marsPhoto.imgSrcUrl).into(ivMarsPhotoImage)
        }
    }
}