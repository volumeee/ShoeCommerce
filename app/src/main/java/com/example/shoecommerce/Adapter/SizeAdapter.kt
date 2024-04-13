package com.example.shoecommerce.Adapter

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoecommerce.Model.BrandModel
import com.example.shoecommerce.R
import com.example.shoecommerce.databinding.ViewholderBrandBinding
import com.example.shoecommerce.databinding.ViewholderColorBinding
import com.example.shoecommerce.databinding.ViewholderSizeBinding

class SizeAdapter(val items:MutableList<String>):RecyclerView.Adapter<SizeAdapter.ViewHolder>() {

    private var selectedPosition=-1
    private var lastSelectedPosition=-1
    private lateinit var context: Context

    class ViewHolder(val binding:ViewholderSizeBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SizeAdapter.ViewHolder {
       context=parent.context
        val binding=ViewholderSizeBinding.inflate(LayoutInflater.from(context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SizeAdapter.ViewHolder, position: Int) {

        holder.binding.sizeTxt.text=items[position]

        holder.binding.root.setOnClickListener{
            lastSelectedPosition=selectedPosition
            selectedPosition=position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }
        if (selectedPosition==position){
            holder.binding.colorLayout.setBackgroundResource(R.drawable.grey_bg_selected)
//            holder.binding.sizeTxt.setTextColor(context.resources.getColor(R.color.purple))
            holder.binding.sizeTxt.setTextColor(ContextCompat.getColor(context, R.color.purple));
        }else{
            holder.binding.colorLayout.setBackgroundResource(R.drawable.grey_bg)
            holder.binding.sizeTxt.setTextColor(ContextCompat.getColor(context, R.color.black));
        }
    }

    override fun getItemCount(): Int = items.size
}