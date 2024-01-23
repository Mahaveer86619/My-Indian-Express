package com.se7en.myindianexpress.screens.onboarding

import androidx.annotation.DrawableRes
import com.se7en.myindianexpress.R

data class Page (
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf<Page>(
    Page(
        title = "Your Daily Dose of Global News",
        description = " Stay informed about what's happening around the globe, from breaking news to in-depth analysis.",
        image = R.drawable.worldwide_news
    ),
    Page(
        title = "Be the First to Know: Live News at Your Fingertips",
        description = "Get instant notifications and real-time updates on the latest developments.",
        image = R.drawable.live_news
    ),
    Page(
        title = "Fuel Your Curiosity: Dive into In-depth Articles and Features",
        description = "Go beyond the headlines and gain deeper insights with our collection of thought-provoking articles, investigative reports, and expert commentary.",
        image = R.drawable.educated
    )

)
