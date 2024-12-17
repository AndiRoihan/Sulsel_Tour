package com.example.sulseltour.mainpage

import androidx.annotation.DrawableRes

data class EventItem(
    @DrawableRes val imageRes: Int,      // Resource for the main image
    val title: String,      // Event title
    val location: String,   // Event location
    val startDate: String,  // Start date
    val endDate: String     // End date
)

data class DestinationItem(
    @DrawableRes val imageRes: Int,      // Resource for the main image
    val title: String,      // Event title
    val location: String,   // Event location
)
