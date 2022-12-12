package com.example.restrofinder.Models

import androidx.room.*


@Entity(
    tableName = "Menu",foreignKeys = [
        ForeignKey(
            entity = Restaurant::class,
            parentColumns = arrayOf("RestaurantID"),
            childColumns = arrayOf("restaurantId"),
            onDelete = ForeignKey.CASCADE
        )],
    indices = [Index(value = ["MenuID"], unique = true)]
)
data class Menu(

    val categories: List<Category>,
    val restaurantId: Int,
    @PrimaryKey
    @ColumnInfo(name="MenuID") val id:Int
)