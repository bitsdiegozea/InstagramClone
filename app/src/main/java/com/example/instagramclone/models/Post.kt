package com.example.instagramclone.models

data class Post(
    val id: Long,
    val title: String,
    val url: String,
    val user: User,
    val like: Boolean
)