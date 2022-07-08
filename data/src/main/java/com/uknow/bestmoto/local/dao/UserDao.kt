package com.uknow.bestmoto.local.dao

import androidx.room.*
import com.uknow.bestmoto.local.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM UserEntity")
    suspend fun getUsers() : List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)

    @Query("DELETE FROM UserEntity")
    suspend fun clearUsers()

}