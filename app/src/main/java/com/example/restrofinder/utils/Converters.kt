package com.example.restrofinder.utils

import androidx.room.TypeConverter
import com.example.restrofinder.Models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    val gson = Gson()
    val listMenuItemType = object : TypeToken<List<MenuItem>>() {}.type
    val listCategoryType = object : TypeToken<List<Category>>() {}.type
    val categoryType = object : TypeToken<Category>() {}.type

    @TypeConverter
    fun fromLatLng(latlng:Latlng):Double{
        return latlng.lat
    }

    @TypeConverter
    fun toLatLng(value:Double):Latlng{
        return Latlng(value,value)
    }

    @TypeConverter
    fun fromOperationHours(operatingHours: OperatingHours):String{
        return operatingHours.Sunday
    }

    @TypeConverter
    fun toLatLng(str:String):OperatingHours{
        return OperatingHours(str,str,str,str,str,str,str)
    }

    @TypeConverter
    fun fromReview(review:Review):String{
        return review.name
    }

    @TypeConverter
    fun toReview(str:String):Review{
        return Review(str,str,str,1)
    }

    @TypeConverter
    fun fromReviews(reviews:List<Review>):String{
        return reviews[0].name
    }

    @TypeConverter
    fun toReviews(str:String):List<Review>{
        return listOf()
    }

    @TypeConverter
    fun fromCategory(category:Category):String{
        return category.id
    }

    @TypeConverter
    fun toCategory(str:String):Category{
        return gson.fromJson(str, categoryType);
    }

    @TypeConverter
    fun fromMenuItem(menuItem:MenuItem):String{
        return menuItem.id
    }

    @TypeConverter
    fun toMenuItem(str:String):MenuItem{
        return MenuItem(str,str,str,str,str)
    }

    @TypeConverter
    fun fromCategories(categories:List<Category>):String{
        return gson.toJson(categories, listCategoryType);
    }

    @TypeConverter
    fun toCategories(str:String):List<Category>{
        return gson.fromJson(str, listCategoryType);
    }

    @TypeConverter
    fun fromMenuItems(menuItems:List<MenuItem>):String{
        return gson.toJson(menuItems, listMenuItemType);
    }

    @TypeConverter
    fun toMenuItems(str:String):List<MenuItem>{
        return gson.fromJson(str, listMenuItemType);
    }

}