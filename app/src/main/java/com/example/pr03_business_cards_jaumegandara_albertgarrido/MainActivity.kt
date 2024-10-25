package com.example.pr03_business_cards_jaumegandara_albertgarrido

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pr03_business_cards_jaumegandara_albertgarrido.ui.theme.Pr03businesscardsjaumegandaraalbertgarridoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pr03businesscardsjaumegandaraalbertgarridoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainLayout(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainLayout(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        // Aquí pots afegir les dues columnes de contingut si ho necessites
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 16.dp)
        ) {
            Form()
            Spacer(modifier = Modifier.height(8.dp))
            CardList()
        }

        // Botó fixat a la part inferior dreta
        Button(
            onClick = { /* Acció del botó */ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp) // Marges des del fons i la dreta
        ) {
            Text("Botó")
        }
    }
}

@Composable
fun Form(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
    ) {
        Text("Form")
    }
}

@Composable
fun CardList(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
    ) {
        Text("CardList")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pr03businesscardsjaumegandaraalbertgarridoTheme {
        MainLayout()
    }
}
