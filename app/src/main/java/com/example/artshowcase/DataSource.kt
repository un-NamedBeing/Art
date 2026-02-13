package com.example.artshowcase

class DataSource {
    fun loadData()=listOf<Page>(
        Page(
            R.drawable._400,
            R.string.cockatiel_des,
            R.string.cockatiel
        ),
        Page(
            R.drawable.lovebirds,
            R.string.love_birds_des,
            R.string.love_birds
        )
    )
}