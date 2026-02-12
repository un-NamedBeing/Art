package com.example.artshowcase

import android.accessibilityservice.GestureDescription
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Page(
    @DrawableRes val image:Int,
    @StringRes val description0: Int,
    @StringRes val description: Int

) {
}