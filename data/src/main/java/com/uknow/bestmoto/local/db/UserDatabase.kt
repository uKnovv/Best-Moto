package com.uknow.bestmoto.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uknow.bestmoto.local.dao.UserDao
import com.uknow.bestmoto.local.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class UserDatabase : RoomDatabase() {
    abstract val dao: UserDao
}