package com.midterm.anythingapp

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home: NavigationItem("home", R.drawable.ic_baseline_home_24, "Home")
    object Music: NavigationItem("music", R.drawable.ic_baseline_music_note_24, "Music")
    object Movie: NavigationItem("movie", R.drawable.ic_baseline_movie_24, "Movie")
    object Books: NavigationItem("books", R.drawable.ic_baseline_book_24, "Books")
    object Tip: NavigationItem("tip", R.drawable.ic_baseline_attach_money_24, "Tip")
    object Portfolio: NavigationItem("portfolio", R.drawable.ic_baseline_person_24, "Portfolio")
    object Profile: NavigationItem("profile", R.drawable.ic_baseline_person_24, "Profile")
    object Tap: NavigationItem("tap", R.drawable.ic_baseline_touch_app_24, "Tap")
}
