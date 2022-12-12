package com.example.restrofinder.database

import com.example.restrofinder.Models.Restaurant
import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.restrofinder.Models.Menu
import androidx.room.*
import com.example.restrofinder.Models.Category
import com.example.restrofinder.Models.MenuItem
import com.example.restrofinder.utils.Converters


@Database(
    entities = [Restaurant::class,Menu::class,Category::class,MenuItem::class],
    version = 5
)
@TypeConverters(Converters::class)
abstract class RestroDatabase : RoomDatabase() {

    abstract fun getRestaurantDAO() : RestaurantDAO
    abstract fun getMenuDAO() : MenuDAO

}