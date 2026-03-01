package com.example.thuchanhcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                    Greeting(
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThucHanhComposeTheme {
        Greeting()
    }
}