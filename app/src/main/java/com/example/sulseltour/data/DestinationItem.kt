package com.example.sulseltour.data

import androidx.annotation.DrawableRes

data class EventItem(
    @DrawableRes val imageRes: Int,      // Resource for the main image
    val title: String,      // Event title
    val location: String,   // Event location
    val startDate: String,  // Start date
    val endDate: String     // End date
)

data class Destination(
    @DrawableRes val imageRes: Int,      // Resource for the main image
    val name: String,      // Event title
    val location: String,   // Event location
)

data class FavoriteItem(
    val id: String = "",
    val name: String = "",
    val description: String = ""
)

