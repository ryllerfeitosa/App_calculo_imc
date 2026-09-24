package com.example.calculadoraimc

import android.R.attr.contentDescription
import android.R.attr.fontWeight
import android.R.attr.onClick
import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadoraimc.ui.theme.CalculadoraIMCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraIMCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    IMCScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun IMCScreen(modifier: Modifier = Modifier){
    var textFieldAltura by remember {
        mutableStateOf("")
    }
    var textFieldPeso by remember {
        mutableStateOf("")
    }
    var imc by remember {
        mutableDoubleStateOf(0.0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxWidth()) {
                //header
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .height(160.dp)
                        .background(color = colorResource(id = R.color.cor_app)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.bmi),
                        contentDescription = "Logo App",
                        modifier = Modifier.size(80.dp)
                            .padding(vertical = 16.dp)
                    )
                    Text(
                        text = "Calculadora IMC",
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
                //Formulario
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 32.dp)
                ) {
                    Card(

                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = (-30).dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFF9F6F6)
                        ),
                        elevation = CardDefaults.cardElevation(4.dp),
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(width = 2.dp, color = Color.White)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .padding(32.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Seus dados",
                                fontSize = 32.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = colorResource(id = R.color.cor_app)
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            OutlinedTextField(
                                value = textFieldAltura,
                                onValueChange = { novoValor ->
                                    textFieldAltura = novoValor
                                },
                                label = {
                                    Text(text = "Altura")
                                },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                shape = RoundedCornerShape(10.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    // Cor de fundo quando focado e não focado (fundo branco)
                                    focusedContainerColor = Color.White,
                                    unfocusedContainerColor = Color.White,

                                    // Cor da borda azul quando está focado (clicado)
                                    focusedBorderColor = colorResource(id = R.color.cor_app),
                                    // Cor da borda azul quando não está focado
                                    unfocusedBorderColor = colorResource(id = R.color.cor_app),

                                    // Cor do texto da label quando focado
                                    focusedLabelColor = colorResource(id = R.color.cor_app)
                                )
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            OutlinedTextField(
                                value = textFieldPeso,
                                onValueChange = { novoValor ->
                                    textFieldPeso = novoValor
                                },
                                label = {
                                    Text(text = "Peso")
                                },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                shape = RoundedCornerShape(10.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    // Cor de fundo quando focado e não focado (fundo branco)
                                    focusedContainerColor = Color.White,
                                    unfocusedContainerColor = Color.White,

                                    // Cor da borda azul quando está focado (clicado)
                                    focusedBorderColor = colorResource(id = R.color.cor_app),
                                    // Cor da borda azul quando não está focado
                                    unfocusedBorderColor = colorResource(id = R.color.cor_app),

                                    // Cor do texto da label quando focado
                                    focusedLabelColor = colorResource(id = R.color.cor_app)
                                )
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            Button(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                onClick = {
                                    // Converte para Double
                                    val altura = textFieldAltura.replace(",", ".").toDouble()
                                    val peso = textFieldPeso.replace(",", ".").toDouble()
                                    if (altura > 0.0) {
                                        imc = peso / (altura * altura)
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.cor_app),

                                ),
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "Calcular",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(15.dp))
                            Button(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                onClick = {
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Cyan,

                                    ),
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "Limpar",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 32.dp)
                ) {
                    Card(

                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = (-30).dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF2E8B57)
                        ),
                        elevation = CardDefaults.cardElevation(4.dp),
                        shape = RoundedCornerShape(10.dp),
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .padding(32.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = String.format("%.1f", imc),
                                fontSize = 32.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }

    }
}