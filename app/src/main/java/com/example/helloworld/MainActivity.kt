package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloworld.ui.theme.HelloWorldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HelloWorldApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun HelloWorldApp(modifier: Modifier = Modifier) {
    var showText by remember { mutableStateOf(false) } // Tracks button click

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if (showText) {
                Text(text = "Hello World!", style = MaterialTheme.typography.headlineMedium)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { showText = true }) {
                Text(text = "Click Here Please")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HelloWorldPreview() {
    HelloWorldTheme {
        HelloWorldApp()
    }
}
