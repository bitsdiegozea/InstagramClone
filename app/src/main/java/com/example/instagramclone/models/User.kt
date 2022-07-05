package com.example.instagramclone.models


data class User(
    val id: Long,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String,
    val alreadySeen: Boolean
)

