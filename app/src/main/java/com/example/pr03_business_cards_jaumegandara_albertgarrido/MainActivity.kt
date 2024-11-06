package com.example.pr03_business_cards_jaumegandara_albertgarrido

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.pr03_business_cards_jaumegandara_albertgarrido.ui.theme.Pr03businesscardsjaumegandaraalbertgarridoTheme

class FormViewModel : ViewModel() {
    var name by mutableStateOf("")
    var showName by mutableStateOf(false)

    var position by mutableStateOf("")
    var showPosition by mutableStateOf(false)

    var description by mutableStateOf("")
    var showDescription by mutableStateOf(false)

    var phone by mutableStateOf("")
    var showPhone by mutableStateOf(false)

    var email by mutableStateOf("")
    var showEmail by mutableStateOf(false)
}

class BusinessCardViewModel : ViewModel() {
    var name by mutableStateOf("")
    var showName by mutableStateOf(false)

    var position by mutableStateOf("")
    var showPosition by mutableStateOf(false)

    var description by mutableStateOf("")
    var showDescription by mutableStateOf(false)

    var phone by mutableStateOf("")
    var showPhone by mutableStateOf(false)

    var email by mutableStateOf("")
    var showEmail by mutableStateOf(false)
}

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
    var showForm by remember { mutableStateOf(true) }

    // Obtén les instàncies de ViewModel
    val formViewModel: FormViewModel = remember { FormViewModel() }
    val businessCardViewModel: BusinessCardViewModel = remember { BusinessCardViewModel() }

    Box(modifier = modifier.fillMaxSize()) {
        if (showForm) {
            Form(formViewModel)
            Button(
                onClick = {
                    // Aquí es transfereix la informació del formulari al model de targeta
                    businessCardViewModel.name = formViewModel.name
                    businessCardViewModel.showName = formViewModel.showName
                    businessCardViewModel.position = formViewModel.position
                    businessCardViewModel.showPosition = formViewModel.showPosition
                    businessCardViewModel.description = formViewModel.description
                    businessCardViewModel.showDescription = formViewModel.showDescription
                    businessCardViewModel.phone = formViewModel.phone
                    businessCardViewModel.showPhone = formViewModel.showPhone
                    businessCardViewModel.email = formViewModel.email
                    businessCardViewModel.showEmail = formViewModel.showEmail

                    showForm = false
                },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Text("Crear", fontSize = 20.sp)
            }
        } else {
            BusinessCard(
                modifier = modifier.padding(16.dp),
                backgroundImage = 1,
                name = businessCardViewModel.name,
                showName = businessCardViewModel.showName,
                position = businessCardViewModel.position,
                showPosition = businessCardViewModel.showPosition,
                description = businessCardViewModel.description,
                showDescription = businessCardViewModel.showDescription,
                phone = businessCardViewModel.phone,
                showPhone = businessCardViewModel.showPhone,
                email = businessCardViewModel.email,
                showEmail = businessCardViewModel.showEmail
            )
            Button(
                onClick = { showForm = true },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
                    .size(72.dp),
                shape = CircleShape,
            ) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Icona credits",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun Form(viewModel: FormViewModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        // Name
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = viewModel.name,
                onValueChange = { viewModel.name = it },
                label = { Text("Nom") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(
                checked = viewModel.showName,
                onCheckedChange = { viewModel.showName = it }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Position
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = viewModel.position,
                onValueChange = { viewModel.position = it },
                label = { Text("Càrrec") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(
                checked = viewModel.showPosition,
                onCheckedChange = { viewModel.showPosition = it }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Description
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = viewModel.description,
                onValueChange = { viewModel.description = it },
                label = { Text("Descripció") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(
                checked = viewModel.showDescription,
                onCheckedChange = { viewModel.showDescription = it }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Phone
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = viewModel.phone,
                onValueChange = { viewModel.phone = it },
                label = { Text("Telèfon") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(
                checked = viewModel.showPhone,
                onCheckedChange = { viewModel.showPhone = it }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Email
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = viewModel.email,
                onValueChange = { viewModel.email = it },
                label = { Text("Correu electrònic") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(
                checked = viewModel.showEmail,
                onCheckedChange = { viewModel.showEmail = it }
            )
        }
    }
}

@Composable
fun BusinessCard(
    modifier: Modifier = Modifier,
    backgroundImage: Int,
    name: String,
    showName: Boolean,
    position: String,
    showPosition: Boolean,
    description: String,
    showDescription: Boolean,
    phone: String,
    showPhone: Boolean,
    email: String,
    showEmail: Boolean
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        Box {
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
                if (showName) {
                    Text(name, color = Color.White, fontSize = 20.sp)
                }
                if (showPosition) {
                    Text(position, color = Color.White, fontSize = 20.sp)
                }
                if (showDescription) {
                    Text(description, color = Color.White, fontSize = 20.sp)
                }
                if (showPhone) {
                    Text(phone, color = Color.White, fontSize = 20.sp)
                }
                if (showEmail) {
                    Text(email, color = Color.White, fontSize = 20.sp)
                }
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