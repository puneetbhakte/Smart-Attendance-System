package com.example.smartattendenceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.smartattendenceapp.adapter.OnBoardingAdapter
import com.example.smartattendenceapp.databinding.ActivityOnBoardingScreenBinding
import com.example.smartattendenceapp.model.Features
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingScreen : AppCompatActivity() {
      private lateinit var binding: ActivityOnBoardingScreenBinding
    private lateinit var adapterViewPager: OnBoardingAdapter
    private val onBoardingPageChangeCallback = object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            val skip = "Skip"
            when (position){
                0 -> {
                    binding.skip.text = skip
                    binding.skip.visibility = View.VISIBLE
                    binding.getStart.visibility = View.GONE
                    binding.skip.isClickable = true
                }
                features.size - 1 -> {
                    binding.getStart.visibility = View.VISIBLE
                    binding.skip.text = ""
                    binding.skip.isClickable = false
                }
                else -> {
                    binding.skip.text = skip
                    binding.skip.isClickable = true
                    binding.skip.visibility = View.VISIBLE
                    binding.getStart.visibility = View.GONE
                }
            }
        }
    }
    val features = arrayListOf<Features>(
            Features(R.drawable.navigation_pana,"Ensure accurate attendance \n" +
            "by only allowing check-ins \n" +
            "within designated office \n" +
            "boundaries.","GPS Fencing"),
        Features(R.drawable.face_recognize,
            "Enhance security and ease of use with facial recognition",
            "Facial Recognition")
        ,Features(R.drawable.real_time,"Keep track of attendance effortlessly with real-time data syncing","Real-Time Attendance Tracking"),
        Features(R.drawable.user_friendly,"Enjoy a seamless and intuitive user experience","User-Friendly Interface"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOnBoardingScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        adapterViewPager = OnBoardingAdapter(this,features)
        binding.viewPager.apply {
            adapter = adapterViewPager
            registerOnPageChangeCallback(onBoardingPageChangeCallback)
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        }

        TabLayoutMediator(binding.tabView,binding.viewPager){tab, position -> }.attach()
        binding.skip.setOnClickListener{
            val intent = Intent(this,StartActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.getStart.setOnClickListener{
            val intent = Intent(this,StartActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


    override fun onDestroy() {
        binding.viewPager.unregisterOnPageChangeCallback(onBoardingPageChangeCallback)
        super.onDestroy()
    }
}