package com.example.study

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class CatsGallery : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.cats_gallery, container, false)

        val bannerList: List<Banner> = listOf(
              Banner(R.drawable.p1),
            Banner(R.drawable.p2),
            Banner(R.drawable.p3),
            Banner(R.drawable.p4),
            Banner(R.drawable.p5),
            Banner(R.drawable.p6),
            Banner(R.drawable.p7),
            Banner(R.drawable.p8),
            Banner(R.drawable.p9),
            Banner(R.drawable.p10),
            Banner(R.drawable.p11),
            Banner(R.drawable.p12),
            Banner(R.drawable.p13),
            Banner(R.drawable.p14),
            Banner(R.drawable.p15),
            Banner(R.drawable.p16),
            Banner(R.drawable.p17),
            Banner(R.drawable.p18),
            Banner(R.drawable.p19),
            Banner(R.drawable.p20),
            Banner(R.drawable.p21),
            Banner(R.drawable.p22),

            )


        val bannersRecyclerView: RecyclerView = view.findViewById(R.id.banners_recyclerView)

        bannersRecyclerView.layoutManager =
            GridLayoutManager(context,2)
        bannersRecyclerView.adapter = BannerAdapter(bannerList)

        return view
    }

}