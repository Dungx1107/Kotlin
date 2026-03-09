package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Calculator(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Calculator(modifier: Modifier = Modifier) {
    Column() {

//        // nhap phep tinh
//        TextField(
//            value = expres
//        )

        CalculatorRow(
            "C", "del", "%", "/",
            Color(0xFFFF69B4), //
            Color(0xFFC3D4BD),// xanh nhat
            Color(0xFFC3D4BD),
            Color(0xFFB38A2E)// vang
        )
        Spacer(modifier = Modifier.height(16.dp))
        CalculatorRow(
            "7", "8", "9", "x",
            Color(0xFFC3D4BD), //
            Color(0xFFC3D4BD),// xanh nhat
            Color(0xFFC3D4BD),
            Color(0xFFB38A2E)// vang
        )
        Spacer(modifier = Modifier.height(16.dp))

        CalculatorRow(
            "4", "5", "6", "-",
            Color(0xFFC3D4BD), //
            Color(0xFFC3D4BD),// xanh nhat
            Color(0xFFC3D4BD),
            Color(0xFFB38A2E)// vang
        )
        Spacer(modifier = Modifier.height(16.dp))

        CalculatorRow(
            "1", "2", "3", "+",
            Color(0xFFC3D4BD), //
            Color(0xFFC3D4BD),// xanh nhat
            Color(0xFFC3D4BD),
            Color(0xFFB38A2E)// vang
        )

        Spacer(modifier = Modifier.height(16.dp))

        CalculatorRow(
            "00", "0", ".", "=",
            Color(0xFFC3D4BD), //
            Color(0xFFC3D4BD),// xanh nhat
            Color(0xFFC3D4BD),
            Color(0xFF2E7D32)// xanh dam
        )


    }
}

@Composable
fun CalculatorRow(
    text1: String,
    text2: String,
    text3: String,
    text4: String,
    color1: Color,
    color2: Color,
    color3: Color,
    color4: Color
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        CalculatorButton(text1, color1)

        Spacer(modifier = Modifier.width(16.dp))

        CalculatorButton(text2, color2)

        Spacer(modifier = Modifier.width(16.dp))

        CalculatorButton(text3, color3)

        Spacer(modifier = Modifier.width(16.dp))

        CalculatorButton(text4, color4)
    }
}

@Composable
fun CalculatorButton(
    text: String,
    color: Color
) {
    Button(
        onClick = {},
        modifier = Modifier.size(80.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorTheme {
        Calculator()
    }
}