package com.example.cupcake.data

import com.example.cupcake.R

object DataSource {
    val quantityOptions = listOf(
        Pair(R.string.one_cupcake, 1),
        Pair(R.string.six_cupcakes, 6),
        Pair(R.string.twelve_cupcakes, 12)
    )

    val flavors = listOf(
        R.string.vanilla,
        R.string.chocolate,
        R.string.red_velvet,
        R.string.salted_caramel,
        R.string.coffee
    )

    val dates = listOf(
        R.string.wed_nov_15,
        R.string.thu_nov_16,
        R.string.fri_nov_17,
        R.string.sat_nov_18
    )

}