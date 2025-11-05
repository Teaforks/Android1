package com.example.android1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android1.ui.theme.Android1Theme
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.res.stringResource
import androidx.core.view.WindowCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false) //alternative to enableEdgeToEdge
        setContent {
            Android1Theme {
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(
                        name = "Mundo",
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/
                SumScreen()
            }
        }
    }
}
/*@Composable
fun MyApp(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "¡Hola $name!",
        modifier = modifier
    )
    var counter by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Button clicked $counter times.")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { counter++ }) {
            Text("Click Me")
        }
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp,28.dp,8.dp,28.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Texto 1: Rojo, grande, negrita",
                color = Color.Red,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(8.dp)
            )
            Text(
                text = "Texto 2: Azul, pequeño, subrayado",
                color = Color.Blue,
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "Texto 3: Verde, mediano, cursiva",
                modifier = Modifier
                    .background(Color.Yellow)
                    .padding(8.dp),
                style = TextStyle(
                    color = Color(0xFF00AA00),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    fontStyle = FontStyle.Italic,
                    shadow = Shadow(
                        color = Color.Black.copy(alpha = 0.5f),
                        offset = Offset(2f, 2f),
                        blurRadius = 4f
                    )
                )
            )
        }
    }
}*/
@Composable
fun SumScreen() {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<Int?>(null) }

    Column (modifier = Modifier
            .fillMaxWidth()
            .background(color =Color.Blue)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ){
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            modifier=Modifier.fillMaxWidth(),
            text= stringResource(id=R.string.sum_name),
            style= TextStyle(
                color=Color.White,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier=Modifier.fillMaxWidth(),
            text="Francisco Vera",
            style= TextStyle(
                color=Color.DarkGray,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(46.dp))
        TextField(
            value = number1,
            onValueChange = { number1 = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = number2,
            onValueChange = { number2 = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val num1 = number1.toIntOrNull()
                val num2 = number2.toIntOrNull()
                if (num1 != null && num2 != null) {
                    result = num1 + num2
                } else {
                    result = null
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("CALCULAR")
        }
        Spacer(modifier = Modifier.height(16.dp))

        result?.let {
            Text("Resultado: $it", style = MaterialTheme.typography.headlineSmall)
        } ?: Text("Introduce números válidos", color = MaterialTheme.colorScheme.error)
    }
}
/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Android1Theme {
        Greeting("Android")
    }
}*/