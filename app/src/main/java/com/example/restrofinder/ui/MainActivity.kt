package com.example.restrofinder.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.restrofinder.Models.Menu
import com.example.restrofinder.Models.Restaurant
import com.example.restrofinder.R
import com.example.restrofinder.utils.JsonToString
import com.example.restrofinder.viewmodels.RestroViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: RestroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = Gson()

        //To fetch data from json file in Stirng format
        val restaurantData = JsonToString.getJsonDataFromAsset(applicationContext,"Restaurant.json")
        val menuData = JsonToString.getJsonDataFromAsset(applicationContext,"Menu.json")

        //To get the type of data returned from json file, like jsonArray or jsonObject
        val listRestaurantType = object : TypeToken<List<Restaurant>>() {}.type
        val listMenuType = object : TypeToken<List<Menu>>() {}.type

        //To convert the json string fetched above to Object of particular type
        var restaurants: List<Restaurant> = gson.fromJson(restaurantData,listRestaurantType)
        var menus: List<Menu> = gson.fromJson(menuData,listMenuType)

        //To insert data in Restaurant and Menu Entities
        viewModel.insertRestaurants(restaurants)
        viewModel.insertMenus(menus)

        //To insert data in Category and MenuItem Entities
        GlobalScope.launch {
            val listCategories:List<String> = viewModel.getListOfCategoriesInString()
            viewModel.populateCategoryTable(listCategories)

            val listMenuItems:List<String> = viewModel.getListOfMenuItemsInString()
            viewModel.populateMenuItemsTable(listMenuItems)
        }







    }
}