package com.example.cupcake.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cupcake.R
import com.example.cupcake.data.DataSource
import com.example.cupcake.data.DataSource.flavors

// 1. Định nghĩa các màn hình
sealed class CupcakeScreen(val route: String) {
    object Start : CupcakeScreen("start")
    object Flavor : CupcakeScreen("flavor")
    object Date : CupcakeScreen("date")

    object Summary : CupcakeScreen("summary")
}

@Composable
fun CupcakeApp(
    viewModel: OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {

    // 2. Mở tờ giấy ghi chú ra để đọc dữ liệu hiện tại
    val uiState by viewModel.uiState.collectAsState()

    // 2. Thiết lập NavHost
    NavHost(
        navController = navController,
        startDestination = CupcakeScreen.Start.route
    ) {

        // MÀN HÌNH 1: Chọn số lượng bánh
        composable(route = CupcakeScreen.Start.route) {
            StartOrderScreen(
                quantityOptions = DataSource.quantityOptions, // Truyền list từ data của em
                onNextButtonClicked = { quantity ->
                    // Khi người dùng chọn số lượng xong -> Chuyển sang chọn Vị
                    // (Thường em sẽ lưu cái quantity này vào ViewModel trước khi chuyển cảnh)
                    viewModel.setQuantity(quantity)
                    navController.navigate(CupcakeScreen.Flavor.route)
                }
            )
        }

        // MÀN HÌNH 2: Chọn hương vị
        composable(route = CupcakeScreen.Flavor.route) {
            SelectOptionScreen(
                onBackButtonClicked = {
                    // Bấm mũi tên trên cùng -> Lùi lại 1 bước
                    navController.navigateUp()
                },
                onCancelButtonClicked = {
                    // Bấm Hủy -> Quay thẳng về màn hình Start và xóa sạch lịch sử ở giữa
                    navController.popBackStack(CupcakeScreen.Start.route, inclusive = false)
                },
                onNextButtonClicked = {
                    navController.navigate(CupcakeScreen.Date.route)
                },
                listRadio = flavors,
                title = R.string.choose_flavor,
                subtotal = uiState.price,
                onOptionSelected = { selectedDate ->
                    viewModel.setDate(selectedDate)
                },
                currentSelectedOption = uiState.date
            )
        }

        // man hinh 3: con ngay
        composable(route = CupcakeScreen.Date.route) {
            SelectOptionScreen(
                onBackButtonClicked = {
                    navController.navigateUp()
                },
                onCancelButtonClicked = {
                    navController.popBackStack(CupcakeScreen.Date.route, inclusive = false)
                },
                onNextButtonClicked = {
                    // Chuyển sang màn hình Ngày lấy bánh (Pickup Screen) - Em sẽ làm phần này sau
                    navController.navigate(CupcakeScreen.Summary.route)
                },
                listRadio = DataSource.dates,
                title = R.string.choose_pickup_date,
                subtotal = uiState.price,
                onOptionSelected = { selectedFlavor ->
                    viewModel.setFlavor(selectedFlavor)
                },
                currentSelectedOption = uiState.flavor
            )
        }


// man hinh 4: tom tat
        composable(route = CupcakeScreen.Summary.route) {
            val list = listOf(uiState.quantity.toString(), uiState.flavor, uiState.date)
            SummaryScreen(
                list,
                onBackButtonClicked = {
                    navController.navigateUp()
                },
                subtotal = uiState.price
            )
        }
    }
}