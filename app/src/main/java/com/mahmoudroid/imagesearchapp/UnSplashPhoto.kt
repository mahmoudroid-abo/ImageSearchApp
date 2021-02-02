package com.mahmoudroid.imagesearchapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UnSplashPhoto(
    val id: String,
    val description: String?,
    val urls: UnSplashPhotoUrls,
    val user: UnSplashUser,
) : Parcelable {

    @Parcelize
    data class UnSplashPhotoUrls(
        val raw: String,
        val regular: String,
        val thumb: String,
        val full: String,
        val small: String
    ) : Parcelable

    @Parcelize
    data class UnSplashUser(
        val name: String,
        val username: String,
        val first_name: String,
        val id: String,
        val instagram_username: String,
        val last_name: String,
        val portfolio_url: String,
        val twitter_username: String,
    ) : Parcelable {
        val attributionUrl get() = "https://unsplash.com/$username?utm_source=IMsearch&utm_medium=referral"
    }
}

