package com.enightclub.app.data.model

data class Story(
    val id: String,
    val username: String,
    val avatarUrl: String = "",
    val isOwnStory: Boolean = false,
    val isViewed: Boolean = false,
    val isOnline: Boolean = false
)
