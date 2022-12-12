package com.example.restrofinder.DI

import android.content.Context
import androidx.room.Room
import com.example.restrofinder.database.RestroDatabase
import com.example.restrofinder.repository.RestroRepository
import com.example.restrofinder.utils.Constants.MY_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context.applicationContext,
        RestroDatabase::class.java,
        MY_DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideRestaurantDao(database: RestroDatabase) = database.getRestaurantDAO()

    @Provides
    @Singleton
    fun provideMenuDao(database: RestroDatabase) = database.getMenuDAO()

    @Provides
    @Singleton
    fun provideRepository(database: RestroDatabase)=RestroRepository(database)

}