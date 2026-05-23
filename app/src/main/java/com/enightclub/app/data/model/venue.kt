package com.enightclub.app.data.model

data class Venue(
    val id: String,
    val name: String,
    val type: String,
    val genres: String,
    val rating: Double,
    val reviewCount: Int,
    val distance: String,
    val isOpen: Boolean = true,
    val imageUrl: String = "",
    val address: String = "",
    val priceLevel: Int = 2,
    val phone: String = ""
)
