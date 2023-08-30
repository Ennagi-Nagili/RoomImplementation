package com.annaginagili

import androidx.room.Database
import androidx.room.RoomDatabase
import com.annaginagili.roomimplementation.data.User
import com.annaginagili.roomimplementation.iroomImpl.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}