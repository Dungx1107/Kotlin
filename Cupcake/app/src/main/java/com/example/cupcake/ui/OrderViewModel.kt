package com.example.cupcake.ui

import androidx.lifecycle.ViewModel
import com.example.cupcake.data.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

private const val PRICE_PER_CUPCAKE = 2.00

class OrderViewModel : ViewModel() {
    // 1. Biến này giữ tờ giấy ghi chú
    // (StateFlow giúp Compose tự động cập nhật UI khi dữ liệu đổi)
    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    //2. ham luu so luong
    fun setQuantity(numberCupcake: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                quantity = numberCupcake,
                price = calculatePrice(quantity = numberCupcake)
            )
        }
    }

    //3.ham luu huong vi
    fun setFlavor(flavor: String) {
        _uiState.update { currentState ->
            currentState.copy(flavor = flavor)
        }
    }

    // 4. Hàm lưu ngày
    fun setDate(pickupDate: String) {
        _uiState.update { currentState ->
            currentState.copy(date = pickupDate)
        }
    }

    // 5. Hàm xóa sạch đơn hàng khi bấm Cancel
    fun resetOrder() {
        _uiState.value = OrderUiState() // Đặt lại về trạng thái ban đầu
    }

    private fun calculatePrice(quantity: Int): String {
        // 1. Tính tiền = Số lượng * Đơn giá
        val calculatedPrice = quantity * PRICE_PER_CUPCAKE

        // 2. Chuyển con số thành chuỗi định dạng tiền tệ (VD: 12.0 -> "$12.00")
        return NumberFormat.getCurrencyInstance().format(calculatedPrice)
    }
}