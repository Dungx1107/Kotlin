package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
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
                Calculator()
            }
        }
    }
}

@Composable
fun Calculator() {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .widthIn(max = 350.dp)   // giới hạn chiều rộng
            .systemBarsPadding()//Né thanh điều hướng và thanh trạng thái
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        var text1 by remember { mutableStateOf("") } // bieu thuc
        var text2 by remember { mutableStateOf("") } // ket qua

        val handleButtonClick: (String) -> Unit = { input ->
            val (newText1, newText2) = CalculatorLogic(input, text1, text2)
            text1 = newText1
            text2 = newText2
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Bottom
        ) {
            // nhap phep tinh
            TextField(
                value = text1,
                onValueChange = { text1 = it },
                label = { Text("input") },
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = text2,
                onValueChange = { text2 = it },
                label = { Text("result") },
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
        }


        CalculatorRow(
            "C", "del", "%", "/",
            Color(0xFFFF69B4), //
            Color(0xFFC3D4BD),// xanh nhat
            Color(0xFFC3D4BD),
            Color(0xFFB38A2E)// vang
            , handleButtonClick
        )

        CalculatorRow(
            "7", "8", "9", "x",
            Color(0xFFC3D4BD), //
            Color(0xFFC3D4BD),// xanh nhat
            Color(0xFFC3D4BD),
            Color(0xFFB38A2E)// vang
            , handleButtonClick

        )

        CalculatorRow(
            "4", "5", "6", "-",
            Color(0xFFC3D4BD), //
            Color(0xFFC3D4BD),// xanh nhat
            Color(0xFFC3D4BD),
            Color(0xFFB38A2E)// vang
            , handleButtonClick

        )

        CalculatorRow(
            "1", "2", "3", "+",
            Color(0xFFC3D4BD), //
            Color(0xFFC3D4BD),// xanh nhat
            Color(0xFFC3D4BD),
            Color(0xFFB38A2E)// vang
            , handleButtonClick

        )

        CalculatorRow(
            "00", "0", ".", "=",
            Color(0xFFC3D4BD), //
            Color(0xFFC3D4BD),// xanh nhat
            Color(0xFFC3D4BD),
            Color(0xFF2E7D32)// xanh dam
            , handleButtonClick

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
    color4: Color,
    onBtnClick: (String) -> Unit // Nhận giá trị nút vừa bấm
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        CalculatorButton(text1, color1, Modifier.weight(1f)) {
            onBtnClick(text1)
        }
        CalculatorButton(text2, color2, Modifier.weight(1f)) {
            onBtnClick(text2)
        }
        CalculatorButton(text3, color3, Modifier.weight(1f)) {
            onBtnClick(text3)
        }
        CalculatorButton(text4, color4, Modifier.weight(1f)) {
            onBtnClick(text4)
        }
    }
}

@Composable
fun CalculatorButton(
    text: String,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(50.dp)
            .aspectRatio(1f) // Tạo nút hình tròn hoàn hảo
        ,
        contentPadding = PaddingValues(0.dp), // Căn giữa chữ
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            softWrap = false

        )
    }
}

fun CalculatorLogic(
    input: String,
    currentText1: String,
    currentText2: String
): Pair<String, String> {
    var nextText1 = currentText1
    var nextText2 = currentText2

    when (input) {
        "C" -> {
            nextText1 = ""
            nextText2 = ""
        }

        "del" -> {
            if (!nextText1.isEmpty()) {
                nextText1.dropLast(1)
            }
        }

        "=" -> {
            try {
                val expressionStr = nextText1.replace("x", "*")
                val result = CalculatorByString(expressionStr)
                if (result % 1 == 0.0) {
                    nextText2 = result.toInt().toString()
                } else {
                    nextText2 = result.toString()
                }
            } catch (e: Exception) {
                nextText2 = "Error"
            }
        }

        else -> {
            nextText1 += input
        }
    }
    return Pair(nextText1, nextText2)
}

fun CalculatorByString(input: String): Double {
    val expressionStr = input.replace("x", "*")
    return net.objecthunter.exp4j
        .ExpressionBuilder(expressionStr)
        .build().evaluate()


}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorTheme {
        Calculator()
    }
}