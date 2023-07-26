package com.example.jetpackcomposedemo

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class NavItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val navRoute: String
) {
    object Home: NavItem(R.string.home, R.drawable.ic_baseline_home, "NAV_HOME")
    object Fav: NavItem(R.string.fav, R.drawable.ic_baseline_favorite, "NAV_FAV")
    object Feed: NavItem(R.string.feed, R.drawable.ic_baseline_feed, "NAV_FEED")
    object Profile: NavItem(R.string.profile, R.drawable.ic_baseline_perso, "NAV_PROFILE")
}
