package com.example.kidogo.ui.families

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kidogo.Family
import com.example.kidogo.R

class FamiliesMainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val families = mutableListOf<Family>()
        val recyclerView = findViewById<RecyclerView>(R.id.family_recycler_view)
        recyclerView.adapter = FamilyItemAdapter(families)
    }
}