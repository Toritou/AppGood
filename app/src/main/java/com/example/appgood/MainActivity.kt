package com.example.appgood

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.appgood.ui.theme.AppGoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppGoodTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding),
                        onExitClick = { finish() }
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier, onExitClick: () -> Unit) {
    var name by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Campo de texto para ingresar el nombre
        TextField(
            value = name,
            onValueChange = { name = it.trim() },
            label = { Text("Ingresa tu nombre") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        // Botón para imprimir el nombre
        Button(
            onClick = {
                if (name.isNotBlank()) {
                    Toast.makeText(context, "Hola, $name", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Por favor ingresa tu nombre", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Imprimir Nombre")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Botón para salir de la aplicación
        Button(
            onClick = { onExitClick() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Salir")
        }
    }
}

