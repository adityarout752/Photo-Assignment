package com.example.photoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RatingBar.OnRatingBarChangeListener
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.photoapp.database.PhotoEntity
import com.example.photoapp.databinding.ItemLayoutBinding
import com.example.photoapp.viewmodel.PhotoViewModel


class PhotoAdapter(
    val context: Context,
    val photoModel: MutableList<PhotoEntity>,
    val photoViewModel: PhotoViewModel
) :
    RecyclerView.Adapter<PhotoAdapter.MyViewHolder>() {
    inner class MyViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val binding = holder.binding

        binding.iv.load(photoModel[position].imageDrawable)
        binding.etReview.setText(photoModel[position].reviewText)

        binding.ratingBar.rating = photoModel[position].ratingStar

        binding.ratingBar.onRatingBarChangeListener = OnRatingBarChangeListener { ratingBar, v, b ->

            val photoPost = photoModel[position]
            val photoEntity = PhotoEntity(
                photoPost.photoId,
                photoPost.imageDrawable,
                ratingBar.rating,
                binding.etReview.editableText.toString()
            )
            photoViewModel.updateData(photoEntity)
        }


    }

    override fun getItemCount(): Int {

        return photoModel.size

    }
}