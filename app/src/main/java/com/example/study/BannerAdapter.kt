package com.example.study

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BannerAdapter(private val bannerList: List<Banner>): RecyclerView.Adapter<BannerViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val bannerView = LayoutInflater.from(parent.context)
            .inflate(R.layout.cats_card,parent,false)

        return BannerViewHolder(bannerView)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val banner = bannerList[position]
        holder.bind(banner)
    }

    override fun getItemCount(): Int {
        return bannerList.size
    }
}