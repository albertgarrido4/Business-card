package com.example.pr03_business_cards_jaumegandara_albertgarrido

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var showForm by remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize()) {
        if (showForm) {
            Form()
        } else {
            BusinessCard(
                modifier = modifier.padding(16.dp),
                backgroundImage = 1
            )
            Button(
                onClick = { showForm = true },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Text("Botó")
            }
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
fun BusinessCard(
    modifier: Modifier = Modifier,
    backgroundImage: Int
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)

    ) {
        Box{
            Image(
                painter = painterResource(id = getBackgroundImage(backgroundImage)),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(20.dp)
            ) {
                Text(
                    "Bart Simpson",
                    color = Color.White,
                    fontSize = 20.sp,
                )
                Text(
                    "Android Developer",
                    color = Color.White,
                    fontSize = 20.sp,
                    )
                Text(
                    "Desenvolupador d'Android amb 5 anys d'experiència a els més grans multinacionals.",
                    color = Color.White,
                    fontSize = 20.sp,
                    )
                Text(
                    "684876999",
                    color = Color.White,
                    fontSize = 20.sp,
                )
                Text(
                    "Exemple@gmail.com",
                    color = Color.White,
                    fontSize = 20.sp,
                )
            }
        }
    }
}

@Composable
fun getBackgroundImage(index: Int): Int {
    return R.drawable.image_1
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pr03businesscardsjaumegandaraalbertgarridoTheme {
        MainLayout()
    }
}
