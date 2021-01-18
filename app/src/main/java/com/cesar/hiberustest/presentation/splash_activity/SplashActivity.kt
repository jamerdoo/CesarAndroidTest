package com.capps.labslogsapp.ui.splash_activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper

import androidx.appcompat.app.AppCompatActivity
import com.cesar.hiberustest.databinding.ActivitySplashBinding
import com.cesar.hiberustest.presentation.home_activity.HomeActivity
import com.cesar.hiberustest.utils._startActivity

class SplashActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySplashBinding

    private val SPLASH_TIME_OUT:Long = 1800 // 1 sec

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSplash()
    }

    private fun initSplash() {
        Handler(Looper.getMainLooper()).postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            _startActivity<HomeActivity>()

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }


}