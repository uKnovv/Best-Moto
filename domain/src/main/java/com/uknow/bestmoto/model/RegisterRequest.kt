package com.uknow.bestmoto.model

data class RegisterRequest(
    val login: String,
    val name: String,
    val password: String
)
