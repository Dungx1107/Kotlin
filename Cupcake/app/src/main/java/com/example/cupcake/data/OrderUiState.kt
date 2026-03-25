package com.example.cupcake.data


// Tờ giấy này ghi lại toàn bộ trạng thái của 1 đơn hàng
data class OrderUiState(

    val quantity: Int = 0,
    val flavor: String = "",
    val date: String = "",
    val price: String = ""
)
