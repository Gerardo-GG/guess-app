package com.pichis.guess.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import com.pichis.guess.BuildConfig
import com.pichis.guess.presentation.theme.GuessTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GuessTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )

                    Button(onClick = {
                        lifecycleScope.launch {
                            try {
                                val generativeModel = GenerativeModel(
                                    modelName = "gemini-1.5-flash",
                                    apiKey = BuildConfig.GEMINI_API_KEY
                                )

                                val prompt = "Dame un listado de 10 peliculas de Disney en el siguiente formato [..., ..., ...]"
                                val response = generativeModel.generateContent(prompt)

                                Log.d("GeminiResponse", response.text ?: "Respuesta vacía")
                            } catch (e: Exception) {
                                Log.e("GeminiError", "Error al generar contenido", e)
                            }
                        }
                    }) {
                        Text("Lanzar conversación")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GuessTheme {
        Greeting("Android")
    }
}