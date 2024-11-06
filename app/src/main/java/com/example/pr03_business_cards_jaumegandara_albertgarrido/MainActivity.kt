package com.example.pr03_business_cards_jaumegandara_albertgarrido

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

    var backgroundImage by mutableStateOf(R.drawable.image_1) // Imagen seleccionada por defecto

    // Método para calcular el progreso basado en checkboxes seleccionados
    fun calculateProgress(): Float {
        val totalSteps = 5 // Nombre, Cargo, Descripción, Teléfono, Correo electrónico
        val completedSteps = listOf(
            showName && name.isNotEmpty(),
            showPosition && position.isNotEmpty(),
            showDescription && description.isNotEmpty(),
            showPhone && phone.isNotEmpty(),
            showEmail && email.isNotEmpty()
        ).count { it }

        return completedSteps / totalSteps.toFloat()
    }
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

    var backgroundImage by mutableStateOf(R.drawable.image_1) // Imagen seleccionada
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

    // Obtén las instancias de ViewModel
    val formViewModel: FormViewModel = remember { FormViewModel() }
    val businessCardViewModel: BusinessCardViewModel = remember { BusinessCardViewModel() }

    Box(modifier = modifier.fillMaxSize()) {
        if (showForm) {
            Form(formViewModel)
            Button(
                onClick = {
                    // Transferir datos del formulario al modelo de la tarjeta
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
                    businessCardViewModel.backgroundImage = formViewModel.backgroundImage

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
                backgroundImage = businessCardViewModel.backgroundImage,
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
                    contentDescription = "Editar tarjeta",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun Form(viewModel: FormViewModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        // Indicador de progreso
        Text("Progreso de creación", style = MaterialTheme.typography.titleMedium)
        LinearProgressIndicator(
            progress = viewModel.calculateProgress(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nombre
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = viewModel.name,
                onValueChange = { viewModel.name = it },
                label = { Text("Nombre") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(
                checked = viewModel.showName,
                onCheckedChange = { viewModel.showName = it }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Cargo
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = viewModel.position,
                onValueChange = { viewModel.position = it },
                label = { Text("Cargo") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(
                checked = viewModel.showPosition,
                onCheckedChange = { viewModel.showPosition = it }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Descripción
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = viewModel.description,
                onValueChange = { if (it.length <= 70) viewModel.description = it },
                label = { Text("Descripción") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(
                checked = viewModel.showDescription,
                onCheckedChange = { viewModel.showDescription = it }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Teléfono
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = viewModel.phone,
                onValueChange = { if (it.all { char -> char.isDigit() }) viewModel.phone = it },
                label = { Text("Teléfono") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(
                checked = viewModel.showPhone,
                onCheckedChange = { viewModel.showPhone = it }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Correo electrónico
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = viewModel.email,
                onValueChange = { viewModel.email = it },
                label = { Text("Correo electrónico") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(
                checked = viewModel.showEmail,
                onCheckedChange = { viewModel.showEmail = it }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Selector de imágenes
        Text("Selecciona la imagen de fondo", style = MaterialTheme.typography.titleMedium)
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            val images = listOf(
                R.drawable.image_1,
                R.drawable.image_2,
                R.drawable.image_3,
                R.drawable.image_4,
                R.drawable.image_5
            )

            images.forEach { imageRes ->
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .clickable { viewModel.backgroundImage = imageRes }
                        .border(
                            width = if (viewModel.backgroundImage == imageRes) 2.dp else 0.dp,
                            color = Color.Blue,
                            shape = MaterialTheme.shapes.medium
                        )
                )
            }
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
    val visibleFields = listOf(showName, showPosition, showDescription, showPhone, showEmail).count { it }
    val cardHeightPercentage = when (visibleFields) {
        5 -> 1.0f
        4 -> 0.8f
        3 -> 0.8f
        2 -> 0.8f
        1 -> 0.8f
        else -> 0.8f
    }

    val cardHeight = (250.dp * cardHeightPercentage).coerceAtLeast(100.dp)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(cardHeight)    ) {
        Box {
            Image(
                painter = painterResource(id = backgroundImage),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(20.dp)
            ) {
                if (showName) Text(name, color = Color.White, fontSize = 40.sp)
                if (showPosition) Text(position, color = Color.White, fontSize = 30.sp)
                if (showDescription) Text(description, color = Color.White, fontSize = 18.sp)
                if (showPhone) Text(phone, color = Color.White, fontSize = 20.sp)
                if (showEmail) Text(email, color = Color.White, fontSize = 20.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pr03businesscardsjaumegandaraalbertgarridoTheme {
        MainLayout()
    }
}