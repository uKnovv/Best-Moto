package com.uknow.bestmoto.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    val profile_img: String?,
    val name: String?,
    val email: String?,
    val password: String?,
    @PrimaryKey val id: Int?
)
