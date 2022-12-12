package com.example.restrofinder.database

import androidx.room.*
import com.example.restrofinder.Models.Category
import com.example.restrofinder.Models.Menu
import com.example.restrofinder.Models.MenuItem


@Dao
interface MenuDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(menu:Menu)

    @Delete
    suspend fun delete(menu: Menu)

    @Query("SELECT categories FROM Menu")
    suspend fun getListOfCategoriesInString():List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

    @Query("SELECT menu_items FROM Category")
    suspend fun getListOfMenuItemsInString():List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMenuItem(menuItem: MenuItem)
}