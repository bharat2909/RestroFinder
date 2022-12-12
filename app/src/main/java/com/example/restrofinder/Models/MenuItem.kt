package com.example.restrofinder.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "MenuItem",
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = arrayOf("CategoryID"),
            childColumns = arrayOf("c_id"),
            onDelete = ForeignKey.CASCADE
        )]
)
data class MenuItem(
    val description: String,
    @PrimaryKey
    @ColumnInfo(name="MenuItemID") val id: String,
    @ColumnInfo(name="MenuItemName") val name: String,
    val price: String,
    val c_id:String
)