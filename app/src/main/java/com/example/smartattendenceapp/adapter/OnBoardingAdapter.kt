package com.example.smartattendenceapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.smartattendenceapp.OnBoardingViewPager
import com.example.smartattendenceapp.model.Features

class OnBoardingAdapter(activity:FragmentActivity,val pagerList:ArrayList<Features>):FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return pagerList.size
    }

    override fun createFragment(position: Int): Fragment {
        return OnBoardingViewPager(pagerList[position])
    }
}