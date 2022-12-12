package com.example.restrofinder.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restrofinder.Models.*
import com.example.restrofinder.repository.RestroRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestroViewModel @Inject constructor(
    private val repository: RestroRepository
): ViewModel() {

    val gson=Gson()
     fun insertRestaurant(restaurant: Restaurant)=viewModelScope.launch {
         repository.insertRestaurant(restaurant)
     }

    fun insertMenu(menu: Menu)=viewModelScope.launch {
        repository.insertMenu(menu)
    }

    fun deleteRestaurant(restaurant: Restaurant)=viewModelScope.launch {
        repository.deleteRestaurant(restaurant)
    }
    suspend fun deleteMenu(menu: Menu)=viewModelScope.launch {
        repository.deleteMenu(menu)
    }

    fun insertRestaurants(restaurantList:List<Restaurant>){
        for(restaurant in restaurantList){
            insertRestaurant(restaurant)
        }
    }

    fun insertMenus(menuList:List<Menu>){
        for(menu in menuList){
            insertMenu(menu)
        }
    }

    //To fetch List of Categories as String from Menu table.
    suspend fun getListOfCategoriesInString():List<String>{
        return repository.getListOfCategoriesInString()
    }

    //To populate category table from list of categories we fetch from menu table.
    suspend fun populateCategoryTable(categoryList:List<String>){
        for(categoryString in categoryList){
            val category1:List<Category> = gson.fromJson(categoryString,object : TypeToken<List<Category>>() {}.type)
            for(category in category1){
                repository.insertCategory(category)
            }
        }
    }



    //To fetch List of MenuItems as String from Category table.
    suspend fun getListOfMenuItemsInString():List<String>{
        return repository.getListOfMenuItemsInString()
    }

    //To populate MenuItems table from list of menuItems we fetch from category table.
    suspend fun populateMenuItemsTable(menuItemList:List<String>){
        for(menuItemString in menuItemList){
            val menuItem1:List<MenuItem> = gson.fromJson(menuItemString,object : TypeToken<List<MenuItem>>() {}.type)
            for(menuItem in menuItem1){
                repository.insertMenuItem(menuItem)
            }
        }
    }

    suspend fun searchRestaurant(query: String): List<Items> {

        var resultList: List<Items> = listOf()

        val nameList: List<Items> = repository.getAllRestaurantsWithRestaurantName(query)
        val cuisineList: List<Items> = repository.getAllRestaurantsWithCuisineType(query)
        val menuItemList: List<Items> = repository.getRestaurantsWithMenuItemName(query)

        resultList += nameList
        resultList += cuisineList
        resultList += menuItemList
        
        return resultList.toSet().toList()

    }
}