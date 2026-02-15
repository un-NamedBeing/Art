package com.example.artshowcase

class DataSource {
    fun loadData()=listOf<Page>(
        Page(
            R.drawable.banquet_piece_with_mince_pie_1991_87_1,
            R.string.banquet_piece_with_mince_pie,
            R.string.willem_claesz_heda,
            R.string.date_banquet_piece_with_mince_pie
        ),
        Page(
            R.drawable.the_mill_1942_9_62,
            R.string.the_mill,
            R.string.rembrandt_van_rijn,
            R.string.date_the_mill
        ),
        Page(
            R.drawable.basket_of_flowers_1992_51_2,
            R.string.basket_of_flowers,
            R.string.balthasar_van_der_ast,
            R.string.date_basket_of_flowers
        )
    )
}