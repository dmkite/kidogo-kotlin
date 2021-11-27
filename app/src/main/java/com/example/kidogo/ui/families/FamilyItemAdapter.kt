package com.example.kidogo.ui.families

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kidogo.Family
import com.example.kidogo.R

class FamilyItemAdapter(
    private val families: MutableList<Family>
): RecyclerView.Adapter<FamilyItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.family_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.family_list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount() = families.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = families[position]
        holder.textView.text = item.familyName

    }
}