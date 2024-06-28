package com.example.xuly_giaodien

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.xuly_giaodien.ui.theme.Xuly_giaodienTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Xuly_giaodienTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Main()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Main() {

    var soA by remember {
        mutableStateOf("")
    }

    var soB by remember {
        mutableStateOf("")
    }

    var ketQua by remember {
        mutableStateOf("")
    }

    fun getKetQua(){
        ketQua = (soA.toInt() + soB.toInt()).toString()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        TextField(
            value = soA,
            onValueChange = {soA = it},
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxWidth(),
            placeholder = {
                Text(text = "Nhập số A")
            }
        )

        TextField(
            value = soB,
            onValueChange = {soB = it},
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxWidth(),
            placeholder = {
                Text(text = "Nhập số B")
            }
        )

        Button(onClick = {getKetQua()}) {
            Text(text = "In ra kết quả")
        }

        Text(text = "Kết quả trả về là: " + ketQua)
    }
}