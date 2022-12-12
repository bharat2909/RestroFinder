package com.example.restrofinder.database


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.restrofinder.Models.Items
import com.example.restrofinder.Models.Restaurant

@Dao
interface RestaurantDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(restaurant: Restaurant)

    @Query("SELECT DISTINCT RestaurantID,RestaurantName,cuisine_type,image FROM Restaurants WHERE RestaurantName LIKE '%' || :name || '%'")
    suspend fun getAllRestaurantsWithRestaurantName(name:String):List<Items>

    @Query("SELECT DISTINCT RestaurantID,RestaurantName,cuisine_type,image FROM Restaurants WHERE cuisine_type LIKE '%' || :cuisine || '%'")
    suspend fun getAllRestaurantsWithCuisineType(cuisine:String):List<Items>

    @Query("SELECT DISTINCT RestaurantName,cuisine_type,image FROM " +
            "Restaurants r, Menu m, Category c, MenuItem mi WHERE r.RestaurantID = m.restaurantId and m.MenuId=c.m_id and c.CategoryID=mi.c_id and mi.MenuItemName LIKE '%' || :name || '%'")
    suspend fun getRestaurantsWithMenuItemName(name:String):List<Items>

    @Delete
    suspend fun delete(restaurant: Restaurant)

}