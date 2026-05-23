package com.enightclub.app.data.model

data class Event(
    val id: String,
    val name: String,
    val venue: String,
    val dj: String,
    val date: String,
    val dayOfWeek: String,
    val dayNumber: String,
    val time: String,
    val price: String,
    val isFree: Boolean = false,
    val imageUrl: String = "",
    val isFeatured: Boolean = false,
    val isTrending: Boolean = false,
    val attendees: Int = 0,
    val distance: String = "",
    val genre: String = ""
)
