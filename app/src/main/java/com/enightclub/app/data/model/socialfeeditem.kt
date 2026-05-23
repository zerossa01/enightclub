package com.enightclub.app.data.model

data class SocialFeedItem(
    val id: String,
    val userName: String,
    val userAvatar: String = "",
    val action: String,
    val targetEvent: String = "",
    val timeAgo: String,
    val likes: Int = 0,
    val comments: Int = 0,
    val isLiked: Boolean = false,
    val imageUrl: String = ""
)
