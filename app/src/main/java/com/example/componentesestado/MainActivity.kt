package com.example.componentesestado


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
                        .background(Color(255, 255, 255)) /* <--
                         -- Utilização de RGB para definição da cor
                        */
                        .fillMaxSize()
                    ) {
                        BasicComponentsScreen()
                        Column(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .fillMaxSize()
                            ,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AndroidEnemy(
                                modifier = Modifier
                                    .padding(innerPadding)
                                    .size(200.dp)
                                    .align(Alignment.CenterHorizontally)
                                ,
                                color = Color(0xFFF54927)
                            )
                            AndroidEnemy(
                                modifier = Modifier
                                    .padding(innerPadding)
                                    .size(200.dp)
                                    .align(Alignment.CenterHorizontally)
                                ,
                                color = Color.DarkGray
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun BasicComponentsScreen(modifier: Modifier = Modifier){
        Column(modifier
            .fillMaxWidth()
            .background(Color(0xFFCC0000)) //Utilização de código hexadecimal para definição da cor
            .padding(20.dp)
        ) {
            Text(
                text = "Aulas Android",
                textAlign = TextAlign.End,
                color = Color(0xFFFFFFFF),
                fontSize = 22.sp, // Modificando o tamanho da fonte
                fontWeight = FontWeight.Bold, //Definição da grossura da fonte
                fontFamily = metamorphous_font, //Utilização de fonte importada
                modifier = Modifier
                    .fillMaxWidth(),
                letterSpacing = 4.sp
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = "com JetPack Compose",
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = FontFamily.SansSerif //Utilização de fonte padrão do JetPack Compose
            )
        }
    }

    @Composable
    fun AndroidEnemy(
        color:Color, modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier,
        ) {
            Image(
                modifier = modifier,
                painter = painterResource(R.drawable.android_logo_by_vexels),
                colorFilter = ColorFilter.tint(color),
                contentDescription = "Android Enemy",
            )
        }
    }
}

