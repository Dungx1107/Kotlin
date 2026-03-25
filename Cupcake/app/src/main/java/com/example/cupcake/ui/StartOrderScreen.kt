package com.example.cupcake.ui

import android.content.res.Resources
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cupcake.R
import com.example.cupcake.data.DataSource.quantityOptions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartOrderScreen(
    quantityOptions: List<Pair<Int, Int>>,
    onNextButtonClicked: (Int) -> Unit
) {

    val appName: String = stringResource(R.string.cupcake)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = appName) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFE3A7D0)
                )
            )

        },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(R.drawable.cupcake),
                        contentDescription = "Cup cake",
                        modifier = Modifier
                            .size(200.dp)
                            .padding(top = 25.dp, bottom = 30.dp)
//                            .align(Alignment.CenterHorizontally) // ko co tac dung can giua
                    )

                    Text(
                        text = stringResource(R.string.order_cupcakes),
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.CenterHorizontally),
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    quantityOptions.forEach { it ->
                        SelectQuantityButton(
                            ResourceId = it.first,
                            onClick = { onNextButtonClicked(it.second) }
                        )
                    }

                }
            }

        }
    )
}

@Composable
fun SelectQuantityButton(
    @StringRes ResourceId: Int,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp), colors = ButtonDefaults.buttonColors(
            containerColor = Color(156, 39, 176, 255),
            contentColor = Color.White
        )
    ) {
        Text(text = stringResource(ResourceId))
    }
}

@Composable
@Preview
fun StartOrderScreenPreview() {
    StartOrderScreen(quantityOptions, onNextButtonClicked = {}
    )
}