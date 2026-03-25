package com.example.cupcake.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cupcake.R
import com.example.cupcake.data.DataSource.flavors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectOptionScreen(
    onCancelButtonClicked: () -> Unit, // <-- 1. Nút Hủy
    onNextButtonClicked: () -> Unit,   // <-- 2. Nút Đi tiếp
    onBackButtonClicked: () -> Unit,    // <-- 3. Nút Quay lại
    listRadio: List<Int>, // danh sach ten radio button hien ra
    title: Int,
    subtotal: String,
    currentSelectedOption: String,      // 1. Nhận giá trị đang chọn từ ViewModel truyền xuống
    onOptionSelected: (String) -> Unit  // 2
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(title)) },// truyen bang lamda {}
                navigationIcon = { // icon ben trai
                    IconButton(onClick = onBackButtonClicked) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "back"
                        )
                    }
                },
//                actions = { // icon ben phai
//                    IconButton(...) { ... }
//                }
//                ,
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFE3A7D0)
                )
            )
        },
        content = { it ->
            Column(modifier = Modifier.padding(it)) {
                ListOption(
                    options = listRadio,
                    // Hai biến này em phải lấy từ trên tham số của hàm SelectOptionScreen truyền xuống nhé!
                    currentSelectedOption = currentSelectedOption,
                    onOptionSelected = onOptionSelected
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = stringResource(R.string.subtotal) + ": $subtotal",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth(),
                containerColor = MaterialTheme.colorScheme.primaryContainer,

                ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
//                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Button(
                        onClick = onCancelButtonClicked,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(255, 255, 255, 255)
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Cancel",
                            color = Color(133, 53, 53, 255)
                        )
                    }

                    Button(
                        onClick = onNextButtonClicked,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(133, 53, 53, 255)
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(16.dp)

                    ) {
                        Text(text = "Next")
                    }
                }
            }
        }
    )
}

@Composable
fun ListOption(
    options: List<Int>,
    currentSelectedOption: String,      // 1. Nhận giá trị đang chọn từ ViewModel truyền xuống
    onOptionSelected: (String) -> Unit  // 2. Cái "đường ống" để ném cái tên Vị (hoặc Ngày) ra ngoài)
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        options.forEach { it ->
            // BƯỚC QUAN TRỌNG: Dịch cái mã ID (Int) thành Chữ (String) ngay tại đây
            // VD: R.string.vanilla -> "Vanilla"
            val stringItem = stringResource(it)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .selectable(
                        selected = currentSelectedOption == stringItem,
                        onClick = { onOptionSelected(stringItem) }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = currentSelectedOption == stringItem,
                    onClick = null
                )

                Text(
                    text = stringResource(it),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }

        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Composable
@Preview
fun SelectFlavorPreview() {
    SelectOptionScreen(
        onCancelButtonClicked = {},
        onNextButtonClicked = {},   // <-- 2. Nút Đi tiếp
        onBackButtonClicked = {},    // <-- 3. Nút Quay lại
        flavors,
        R.string.choose_flavor,
        "10",
        "kaka",
        {}
    )
}