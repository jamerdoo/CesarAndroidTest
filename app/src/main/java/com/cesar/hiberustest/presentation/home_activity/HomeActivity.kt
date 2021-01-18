package com.cesar.hiberustest.presentation.home_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cesar.hiberustest.databinding.ActivityMainBinding
import com.cesar.hiberustest.utils.Logger

class HomeActivity : AppCompatActivity() ,Logger{

    override val nameClass: String get() = "--->"+javaClass.simpleName
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}