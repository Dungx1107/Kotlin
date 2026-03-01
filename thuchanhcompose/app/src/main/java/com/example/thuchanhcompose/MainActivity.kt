package com.example.thuchanhcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thuchanhcompose.ui.theme.ThucHanhComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThucHanhComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    GocPhanTuTrongComposable(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier,
    ) {
        val image = painterResource(R.drawable.bg_compose_background)
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.text1),
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
//                .fillMaxSize()
        )
        Text(
            text = stringResource(R.string.text2),
            modifier = Modifier
                .padding(16.dp, 0.dp, 16.dp),
//                .fillMaxSize(),
            textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(R.string.text3),
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp, 16.dp, 16.dp, 16.dp)

        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ThucHanhComposeTheme {
//        Greeting()
//    }
//}

@Composable
fun GocPhanTuTrongComposable(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize() //phải chiến hết chiều dài của Row hoặc thành phần chứa nó thì mới căn được chữ vào giữa
                    .background(
                        color = Color(0xFFEADDFF)
                    )
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.text41),
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                )
                Text(
                    text = stringResource(R.string.text42),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.align(Alignment.CenterHorizontally)

                )
            }
            Column(
                modifier = Modifier
                    .background(
                        color = Color(0xFFD0BCFF)
                    )
                    .weight(1f)
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.text43),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.Bold,

                    )
                Text(
                    text = stringResource(R.string.text44),
                    textAlign = TextAlign.Justify

                )
            }
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),

            ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = Color(0xFFB69DF8)
                    )
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center

            ) {
                Text(
                    text = stringResource(R.string.text45),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.Bold,

                    )
                Text(
                    text = stringResource(R.string.text46),
                    textAlign = TextAlign.Justify

                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = Color(0xFFF6EDFF)
                    )
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center

            ) {
                Text(
                    text = stringResource(R.string.text47),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.Bold,

                    )
                Text(
                    text = stringResource(R.string.text48),
                    textAlign = TextAlign.Justify

                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview1() {
    ThucHanhComposeTheme {
        GocPhanTuTrongComposable()
    }
}