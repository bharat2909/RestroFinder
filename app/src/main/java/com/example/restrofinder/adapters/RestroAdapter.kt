package com.example.restrofinder.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restrofinder.Models.Items
import com.example.restrofinder.R
import kotlinx.android.synthetic.main.search_item.view.*

class RestroAdapter : RecyclerView.Adapter<RestroAdapter.RestaurantViewHolder>()  {

    inner class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallBack = object : DiffUtil.ItemCallback<Items>() {
        override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem.RestaurantName== newItem.RestaurantName
        }

        override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.search_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = differ.currentList.get(position)

        holder.itemView.apply {
            Glide.with(this).load(restaurant.image).into(sivImage)
            tvRestaurantName.text=restaurant.RestaurantName
            tvCuisine.text=restaurant.cuisine_type
        }

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}