package com.example.smartattendenceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smartattendenceapp.databinding.FragmentOnBoardingViewPagerBinding
import com.example.smartattendenceapp.model.Features


class OnBoardingViewPager(val page:Features) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var  binding: FragmentOnBoardingViewPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardingViewPagerBinding.inflate(layoutInflater,container,false)

        binding.imageView.setBackgroundResource(page.image)
        binding.titleTxt.text = page.title
        binding.descTxt.text = page.description

        return binding.root
    }

    companion object {

    }
}