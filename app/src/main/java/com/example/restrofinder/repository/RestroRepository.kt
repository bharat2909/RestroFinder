package com.example.restrofinder.repository

import com.example.restrofinder.Models.*
import com.example.restrofinder.database.MenuDAO
import com.example.restrofinder.database.RestaurantDAO
import com.example.restrofinder.database.RestroDatabase
import javax.inject.Inject

class RestroRepository @Inject constructor(
    val restroDatabase: RestroDatabase
) {

    suspend fun insertRestaurant(restaurant: Restaurant){
        restroDatabase.getRestaurantDAO().insert(restaurant)
    }

    suspend fun insertMenu(menu: Menu){
       restroDatabase.getMenuDAO().insert(menu)
    }

    suspend fun insertCategory(category: Category){
        restroDatabase.getMenuDAO().insertCategory(category)
    }

    suspend fun insertMenuItem(menuItem: MenuItem){
        restroDatabase.getMenuDAO().insertMenuItem(menuItem)
    }

    suspend fun deleteRestaurant(restaurant: Restaurant){
        restroDatabase.getRestaurantDAO().delete(restaurant)
    }

    suspend fun deleteMenu(menu: Menu){
        restroDatabase.getMenuDAO().delete(menu)
    }

    suspend fun getListOfCategoriesInString():List<String>{
        return restroDatabase.getMenuDAO().getListOfCategoriesInString()
    }

    suspend fun getListOfMenuItemsInString():List<String>{
        return restroDatabase.getMenuDAO().getListOfMenuItemsInString()
    }

    suspend fun getAllRestaurantsWithRestaurantName(name:String):List<Items>{
        return restroDatabase.getRestaurantDAO().getAllRestaurantsWithRestaurantName(name)
    }

    suspend fun getAllRestaurantsWithCuisineType(cuisine:String):List<Items>{
        return restroDatabase.getRestaurantDAO().getAllRestaurantsWithCuisineType(cuisine)
    }

    suspend fun getRestaurantsWithMenuItemName(name:String):List<Items>{
        return restroDatabase.getRestaurantDAO().getRestaurantsWithMenuItemName(name)
    }

}