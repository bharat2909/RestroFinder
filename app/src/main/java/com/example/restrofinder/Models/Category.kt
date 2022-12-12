package com.example.restrofinder.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Category",
    foreignKeys = [
        ForeignKey(
            entity = Menu::class,
            parentColumns = arrayOf("MenuID"),
            childColumns = arrayOf("m_id"),
            onDelete = ForeignKey.CASCADE
        )]
)
data class Category(
    @PrimaryKey
    @ColumnInfo(name="CategoryID") val id: String,
    val m_id:Int,
    val menu_items: List<MenuItem>,
    @ColumnInfo(name="CategoryName") val name: String
)