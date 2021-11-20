package com.example.study

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BannerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(banner:Banner)
    {
        val bannerImageView_1: ImageView = itemView.findViewById(R.id.banner_image_1)


        bannerImageView_1.setImageDrawable(itemView.context.getDrawable(banner.imageRes))


    }
}