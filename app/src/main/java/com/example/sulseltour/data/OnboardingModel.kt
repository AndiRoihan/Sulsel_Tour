package com.example.sulseltour.data

import androidx.annotation.DrawableRes
import com.example.sulseltour.R

sealed class OnboardingModel(
    @DrawableRes val backgroundImage: Int,
    @DrawableRes val image: Int,
    val title: String,
    val description: String,
) {

    data object FirstPage : OnboardingModel(
        backgroundImage = R.drawable.bg_onboard_1,
        image = R.drawable.img_onboard_1,
        title = "Discover Hidden Gems",
        description = "Explore the beauty of South Sulawesi, from breathtaking beaches to majestic mountains, all in one app"
    )

    data object SecondPage : OnboardingModel(
        backgroundImage = R.drawable.bg_onboard_2,
        image = R.drawable.img_onboard_2,
        title = "Plan Your Adventure",
        description = "Find detailed information about destinations, activities, and event to make your journey unforgettable"
    )

    data object ThirdPages : OnboardingModel(
        backgroundImage = R.drawable.bg_onboard_3,
        image = R.drawable.img_onboard_3,
        title = "Start Exploring Now",
        description = "Your adventure awaits! Let us guide you to South Sulawesi’s best destinations with ease"
    )


}