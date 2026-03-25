package com.example.cupcake.ui

import android.R.color
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cupcake.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SummaryScreen(
    summary: List<String>,
    onBackButtonClicked: () -> Unit,
    subtotal: String
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.order_summary)) },
                navigationIcon = {
                    IconButton(onClick = onBackButtonClicked) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFE3A7D0)
                )
            )
        },
        bottomBar = {
            Surface(
                color = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .navigationBarsPadding() // Đẩy lên để không bị lẹm vào thanh điều hướng của Android

                ) {
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        border = BorderStroke(1.dp, Color.Gray),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(180, 38, 38, 255)
                        )
                    ) {
                        Text(
                            text = stringResource(R.string.send_oder_to_another_app)
                        )
                    }

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        border = BorderStroke(1.dp, Color.Gray),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(255, 255, 255),
                            contentColor = Color(180, 38, 38, 255)
                        )
                    ) {
                        Text(text = stringResource(R.string.cancel))
                    }
                }
            }
        }
    ) { it ->
        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.quantity),
                modifier = Modifier.padding(bottom = 8.dp),
                fontSize = 20.sp,
            )
            Text(
                text = summary[0],
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = stringResource(R.string.flavor),
                modifier = Modifier.padding(bottom = 8.dp),
                fontSize = 20.sp,
            )
            Text(
                text = summary[1],
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = stringResource(R.string.pickup_date),
                modifier = Modifier.padding(bottom = 8.dp),
                fontSize = 20.sp,
            )
            Text(
                text = summary[2],
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )

            Text(
                text = stringResource(R.string.subtotal) + ": $subtotal",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                fontSize = 24.sp,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Bold
            )
        }

    }

}


@Composable
@Preview
fun SummaryScreenPreview() {
    var list = listOf("12", "50", "500")
    SummaryScreen(list, {}, "12")
}