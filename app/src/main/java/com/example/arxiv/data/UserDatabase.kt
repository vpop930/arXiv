package com.example.arxiv.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class, Article::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract val dao: UserDAO
}