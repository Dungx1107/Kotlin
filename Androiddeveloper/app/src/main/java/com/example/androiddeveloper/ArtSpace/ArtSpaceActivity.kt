package com.example.androiddeveloper.ArtSpace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddeveloper.ArtSpace.ui.theme.AndroiddeveloperTheme
import com.example.androiddeveloper.R

class ArtSpaceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroiddeveloperTheme {
                ArtSpaceView()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceView() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Welcome to my ArtSpace",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF6200EE), // mau nen
                    titleContentColor = Color.White
                )
            )
        },

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var imageSource: Int = 1
            var art by remember { mutableStateOf(1) }

            Surface(
                color = Color.LightGray,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(40.dp)
                    .fillMaxWidth()
                    .weight(4f)
            ) {
                imageSource = when (art) {
                    1 -> R.drawable.screenshot_2026_03_07_233845
                    2 -> R.drawable.screenshot_2026_03_01_204328
                    3 -> R.drawable.pt1
                    4 -> R.drawable._61503353_1361895088974630_9120958541536012317_n
                    5 -> R.drawable.pt4
                    6 -> R.drawable._65659823_1361895142307958_8366711677559485111_n
                    else -> {
                        R.drawable.screenshot_2026_03_01_204328
                    }
                }

                Image(
                    painter = painterResource(imageSource),
                    contentDescription = "sergi roberto",
                    modifier = Modifier.padding(40.dp)
                )
            }

            ImageDescription(image = art)
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
                    .weight(2f),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        if (art > 1) {
                            art -= 1
                        } else {
                            art = 6
                        }

                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Privious",
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp,
                        maxLines = 1,
                        softWrap = false // softWrap quyết định Text có tự xuống dòng khi hết chỗ hay không.
                    )
                }
                Button(
                    onClick = {
                        if (art < 6) {
                            art += 1
                        } else {
                            art = 1
                        }
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Next",
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp,
                        maxLines = 1
                    )
                }
            }

        }
    }
}

@Composable
fun ImageDescription(image: Int = 1) {
    val artworkDes = when (image) {
        1 -> Pair("Sergi robesto", "1998")
        2 -> Pair("Virgil vandai", "19999")
        3 -> Pair("phuong tuyen 2026", "2005")
        4 -> Pair("chi kim ", "2025")
        5 -> Pair("phuong tuyến", "2025")
        6 -> Pair("chi nuych", "2025")
        else -> {
            Pair("Sergi robesto", "1998")
        }
    }
    Surface(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = Color.Gray
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = artworkDes.first,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = artworkDes.second
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    AndroiddeveloperTheme {
        ArtSpaceView()
    }
}