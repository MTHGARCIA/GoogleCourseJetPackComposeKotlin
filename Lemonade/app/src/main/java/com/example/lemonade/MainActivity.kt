package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Screen()
                }
            }
        }
    }
}

@Composable
fun TopText(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFF9E44C))
            .padding(bottom = 20.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = "Lemonade",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
    }
}

@Composable
fun MidText(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }

    // Mover squeezeCount e squeezeNeeded para fora do bloco when
    var squeezeCount by remember { mutableStateOf(0) }
    var squeezeNeeded by remember { mutableStateOf((2..4).random()) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (currentStep) {
            1 -> {
                Button(onClick = {
                    currentStep = 2
                    // reset squeeze variables
                    squeezeCount = 0
                    squeezeNeeded = (2..4).random()
                }) {
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = null,
                    )
                }
                Text(
                    text = "Tap the lemon tree to select a lemon",
                    modifier = Modifier.padding(16.dp)
                )
            }
            2 -> {
                Button(onClick = {
                    squeezeCount++
                    if (squeezeCount >= squeezeNeeded) {
                        currentStep = 3
                    }
                }) {
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = null,
                    )
                }
                Text(
                    text = "Keep tapping the lemon to squeeze it",
                    modifier = Modifier.padding(16.dp)
                )
            }
            3 -> {
                Button(onClick = {
                    currentStep = 4
                }) {
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = null,
                    )
                }
                Text(
                    text = "Tap the lemonade to drink it",
                    modifier = Modifier.padding(16.dp)
                )
            }
            4 -> {
                Button(onClick = {
                    currentStep = 1
                }) {
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = null,
                    )
                }
                Text(
                    text = "Tap the empty glass to start again",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun Screen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        TopText(modifier = Modifier
            .weight(0.10f)
            .fillMaxWidth()
        )
        MidText(modifier = Modifier
            .fillMaxWidth()
            .weight(0.90f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        Screen()
    }
}
