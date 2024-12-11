package com.example.sulseltour.onboard

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
        title = "Your Reading Partner",
        description = "Read as many book as you want, anywhere you want"
    )

    data object SecondPage : OnboardingModel(
        backgroundImage = R.drawable.bg_onboard_2,
        image = R.drawable.img_onboard_2,
        title = "Your Personal Library",
        description = "Organize books in different ways, make your own library"
    )

    data object ThirdPages : OnboardingModel(
        backgroundImage = R.drawable.bg_onboard_3,
        image = R.drawable.img_onboard_3,
        title = "Search and Filter",
        description = "Get any book you want within a simple search across your device"
    )


}