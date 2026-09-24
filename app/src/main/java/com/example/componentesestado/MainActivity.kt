package com.example.componentesestado


import android.R.attr.checked
import android.R.attr.contentDescription
import android.R.attr.label
import android.R.attr.top
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
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
                            ContentContainer(Modifier
                                .padding(5.dp, 0.dp)
                                .fillMaxWidth())
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
    fun ContentContainer(modifier: Modifier = Modifier) {
        var textoInput = remember {
            mutableStateOf("")
        }

        var sobrenome by remember {
            mutableStateOf("")
        }

        var idade by  remember {
            mutableStateOf("")
        }

        var email by remember {
            mutableStateOf("")
        }

        var java by remember {
            mutableStateOf(false)
        }

        var kotlin by remember {
            mutableStateOf(false)
        }

        var javascript by remember {
            mutableStateOf(false)
        }

        var sistemaSelecionado by remember {
            mutableStateOf(0)
        }

        var isTodasOpcoes by remember {
            mutableStateOf(false)
        }

        var corDeFundo by remember {
            mutableStateOf(Color.White)
        }

        var favoritado by remember {
            mutableStateOf(false)
        }

        Column(
            modifier = modifier
                .background(corDeFundo)
                .fillMaxSize()
                .padding(10.dp, 5.dp)
        ) {
            TextField(
                modifier = modifier.padding(20.dp, 0.dp),
                value = textoInput.value,
                onValueChange = {
                        novoValor -> Log.i("teste", novoValor)
                    textoInput.value = novoValor
                },
                placeholder = {
                    Text("Digite seu nome")
                },
                label = {
                    Text("Nome")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Icone de pessoa",
                        tint = Color.Black
                    )
                }

            )

            TextField(
                modifier = modifier.padding(20.dp, 0.dp),
                value = sobrenome,
                onValueChange = {
                    sobrenome = it
                },
                placeholder = {
                    Text("Digite seu sobrenome")
                },
                label = {
                    Text("Sobrenome")
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences
                )
            )

            Spacer(Modifier.height(12.dp))

            TextField(
                modifier = modifier.padding(20.dp, 0.dp),
                value = idade,
                onValueChange = {
                        novoValor -> idade = novoValor
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                placeholder = {Text("Digite sua idade")},
                label = {
                    Text("Idade")
                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Blue,
                    unfocusedTextColor = Color.Red,
                    unfocusedPlaceholderColor = Color.Magenta
                ),
                leadingIcon ={
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Descrição",
                    )
                }
            )

            OutlinedTextField(
                modifier = modifier.padding(20.dp, 0.dp),
                value = email,
                onValueChange = {email = it},
                singleLine = true,
                label = {
                    Text("Email")
                },
                placeholder = {
                    Text(text = "Digite seu nome")
                },
                shape = RoundedCornerShape(
                    topStart = 32.dp,
                    topEnd = 32.dp,
                    bottomEnd = 32.dp,
                    bottomStart = 32.dp
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF800080),
                    unfocusedBorderColor = Color(0xFF6585C5)
                )

            )

            Row(  verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = java,
                    onCheckedChange = {java = it},
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.DarkGray,
                        uncheckedColor = Color.LightGray
                    )
                )

                Text("Java")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = kotlin,
                    onCheckedChange = {kotlin = it},
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.DarkGray,
                        uncheckedColor = Color.LightGray
                    )
                )

                Text("Kotlin")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = javascript,
                    onCheckedChange = {javascript = it},
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.DarkGray,
                        uncheckedColor = Color.LightGray
                    )
                )

                Text("Javascript")
            }

            Spacer(Modifier.height(2.dp))
            Text("Qual o seu sistema Operacional?")
            Spacer(Modifier.height(2.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = sistemaSelecionado == 0 || isTodasOpcoes,
                    onClick = {
                        sistemaSelecionado = 0
                        isTodasOpcoes = false
                    }
                )

                Text("MacOs")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = sistemaSelecionado == 1 || isTodasOpcoes,
                    onClick = {
                        sistemaSelecionado = 1
                        isTodasOpcoes = false
                    }
                )

                Text("Linux")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = sistemaSelecionado == 2 || isTodasOpcoes,
                    onClick = {
                        sistemaSelecionado = 2
                        isTodasOpcoes = false
                    }
                )

                Text("Windows")
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = isTodasOpcoes,
                    onClick = {isTodasOpcoes = true}
                )

                Text("Todas as opções")
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Button(
                    onClick = {
                        corDeFundo = Color(0xFFEFE7FE)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF5A00FF),
                        contentColor = Color.White
                    ),
                    border = BorderStroke(.5.dp, Color.Black),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Estrela"
                        )
                        Text("Clique Aqui!")
                    }

                }

                OutlinedButton(
                    onClick = {
                        corDeFundo = Color.White
                    }
                ) {
                    Text("Resetar Cor De Fundo")
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center
            ) {

                if (favoritado){
                    Icon(
                        modifier = Modifier.size(40.dp)
                            .clickable{
                                favoritado = false
                            },
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favoritado"
                    )
                }else{
                    Icon(
                        modifier = Modifier.size(40.dp)
                            .clickable{
                                favoritado = true
                            },
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Desfavoritado"
                    )
                }




            }


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

