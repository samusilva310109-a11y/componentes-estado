package com.example.componentesestado


import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentesestado.ui.theme.ComponentesEstadoTheme
import com.example.componentesestado.ui.theme.metamorphous_font

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentesEstadoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier
                        .padding(innerPadding)
                        .background(Color(239, 247, 200))
                        .fillMaxSize()
                    ) {
                        BasicComponentsScreen()
                    }
                }
            }
        }
    }

    @Composable
    fun BasicComponentsScreen(modifier: Modifier = Modifier){
        Column(modifier
            .fillMaxWidth()
            .background(Color(0xFFCC0000))
            .padding(20.dp)
        ) {
            Text(
                text = "Aulas Android",
                color = Color(0xFFFFFFFF),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = metamorphous_font
            )
            Text(
                text = "com JetPack Compose",
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}

