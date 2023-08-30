package com.annaginagili.roomimplementation.iroomImpl

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.annaginagili.roomimplementation.data.User

@Dao
interface UserDao {
    @Query("Select * from user")
    fun getAll(): List<User>

    @Insert
    fun insertAll(vararg users: User)
}