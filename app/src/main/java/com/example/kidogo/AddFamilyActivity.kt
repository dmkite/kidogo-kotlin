package com.example.kidogo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kidogo.databinding.ActivityAddFamilyBinding

class AddFamilyActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityAddFamilyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}