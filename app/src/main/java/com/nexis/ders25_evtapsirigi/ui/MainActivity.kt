package com.nexis.ders25_evtapsirigi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nexis.ders25_evtapsirigi.Adapter.ServiceAdapter
import com.nexis.ders25_evtapsirigi.R
import com.nexis.ders25_evtapsirigi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}