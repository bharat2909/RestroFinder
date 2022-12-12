package com.example.restrofinder.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "Restaurants"
)
data class Restaurant(
    val address: String,
    val cuisine_type: String,
    @PrimaryKey
    @ColumnInfo(name="RestaurantID") val id: Int,
    val latlng: Latlng,
    @ColumnInfo(name="RestaurantName") val name: String,
    val neighborhood: String,
    val operating_hours: OperatingHours,
    val photograph: String,
    val image:String,
    val reviews: List<Review>
)