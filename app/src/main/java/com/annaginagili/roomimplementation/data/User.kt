package com.annaginagili.roomimplementation.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (@PrimaryKey(autoGenerate = true) val uid: Int, @ColumnInfo(name = "name") val name: String,
                 @ColumnInfo(name = "surname") val surname: String)