package com.example.pr03_business_cards_jaumegandara_albertgarrido

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
    var backgroundImage by mutableIntStateOf(R.drawable.image_1)
    var selectedIcon by mutableStateOf(Icons.Default.Home)
    var showIcon by mutableStateOf(false)
    var enableColor by mutableStateOf(false)
    var selectedColor by mutableStateOf(Color.White)

    fun calculateProgress(): Float {
        val totalSteps = 6
        val completedSteps = listOf(
            showName && name.isNotEmpty(),
            showPosition && position.isNotEmpty(),
            showDescription && description.isNotEmpty(),
            showPhone && phone.isNotEmpty(),
            showEmail && email.isNotEmpty(),
            showIcon
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
    var backgroundImage by mutableIntStateOf(R.drawable.image_1)
    var selectedIcon by mutableStateOf(Icons.Default.Home)
    var showIcon by mutableStateOf(false)
    var enableColor by mutableStateOf(false)
    var selectedColor by mutableStateOf(Color.White)
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
    val formViewModel: FormViewModel = remember { FormViewModel() }
    val businessCardViewModel: BusinessCardViewModel = remember { BusinessCardViewModel() }

    Box(modifier = modifier.fillMaxSize()) {
        if (showForm) {
            Form(formViewModel)
            Button(
                onClick = {
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
                    businessCardViewModel.selectedIcon = formViewModel.selectedIcon
                    businessCardViewModel.showIcon = formViewModel.showIcon
                    businessCardViewModel.enableColor = formViewModel.enableColor
                    businessCardViewModel.selectedColor = formViewModel.selectedColor
                    showForm = false
                },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text("Crear", fontSize = 20.sp, modifier = Modifier.padding(horizontal = 32.dp, vertical = 4.dp))
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
                showEmail = businessCardViewModel.showEmail,
                selectedIcon = businessCardViewModel.selectedIcon,
                showIcon = businessCardViewModel.showIcon,
                enableColor = businessCardViewModel.enableColor,
                selectedColor = businessCardViewModel.selectedColor
            )
            FloatingActionButton(
                onClick = { showForm = true },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp),
                shape = CircleShape,
            ) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Editar targeta",
                )
            }
        }
    }
}

@Composable
fun Form(viewModel: FormViewModel) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.padding(16.dp)
            .padding(bottom = 64.dp)
            .verticalScroll(scrollState)
    ) {
        // Progress bar
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "Progrés de creació",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(8.dp))

                val progress = viewModel.calculateProgress()
                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                )
                Text(
                    "${(progress * 100).toInt()}% completat",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }

        // Form Fields
        OutlinedTextField(
            value = viewModel.name,
            onValueChange = { viewModel.name = it },
            label = { Text("Nom") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Checkbox(
                checked = viewModel.showName,
                onCheckedChange = { viewModel.showName = it }
            )
            Text("Mostrar nom", style = MaterialTheme.typography.bodyMedium)
        }

        OutlinedTextField(
            value = viewModel.position,
            onValueChange = { viewModel.position = it },
            label = { Text("Càrrec") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Checkbox(
                checked = viewModel.showPosition,
                onCheckedChange = { viewModel.showPosition = it }
            )
            Text("Mostrar càrrec", style = MaterialTheme.typography.bodyMedium)
        }

        OutlinedTextField(
            value = viewModel.description,
            onValueChange = { if (it.length <= 70) viewModel.description = it },
            label = { Text("Descripció") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Checkbox(
                checked = viewModel.showDescription,
                onCheckedChange = { viewModel.showDescription = it }
            )
            Text("Mostrar descripció", style = MaterialTheme.typography.bodyMedium)
        }

        OutlinedTextField(
            value = viewModel.phone,
            onValueChange = { if (it.all { char -> char.isDigit() }) viewModel.phone = it },
            label = { Text("Telèfon") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Checkbox(
                checked = viewModel.showPhone,
                onCheckedChange = { viewModel.showPhone = it }
            )
            Text("Mostrar telèfon", style = MaterialTheme.typography.bodyMedium)
        }

        OutlinedTextField(
            value = viewModel.email,
            onValueChange = { viewModel.email = it },
            label = { Text("Correu electrònic") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Checkbox(
                checked = viewModel.showEmail,
                onCheckedChange = { viewModel.showEmail = it }
            )
            Text("Mostrar correu", style = MaterialTheme.typography.bodyMedium)
        }

        // Image Selection
        Text("Selecciona la imatge de fons", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            listOf(
                R.drawable.image_1,
                R.drawable.image_2,
                R.drawable.image_3,
                R.drawable.image_4,
                R.drawable.image_5
            ).forEach { imageRes ->
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(
                            width = if (viewModel.backgroundImage == imageRes) 2.dp else 1.dp,
                            color = if (viewModel.backgroundImage == imageRes)
                                MaterialTheme.colorScheme.primary
                            else Color.Gray,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clickable { viewModel.backgroundImage = imageRes },
                    contentScale = ContentScale.Crop
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Icon Selection
        Text("Selecciona una icona", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            listOf(
                Icons.Default.Home,
                Icons.Default.Star,
                Icons.Default.Favorite,
                Icons.Default.Info,
                Icons.Default.LocationOn
            ).forEach { icon ->
                IconButton(
                    onClick = { viewModel.selectedIcon = icon },
                    modifier = Modifier
                        .size(48.dp)
                        .border(
                            width = if (viewModel.selectedIcon == icon) 2.dp else 1.dp,
                            color = if (viewModel.selectedIcon == icon)
                                MaterialTheme.colorScheme.primary
                            else Color.Gray,
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = if (viewModel.selectedIcon == icon)
                            MaterialTheme.colorScheme.primary
                        else Color.Gray
                    )
                }
            }
            Checkbox(
                checked = viewModel.showIcon,
                onCheckedChange = { viewModel.showIcon = it }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Color Selection
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                checked = viewModel.enableColor,
                onCheckedChange = { viewModel.enableColor = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Habilitar color en els texts")
        }

        if (viewModel.enableColor) {
            Spacer(modifier = Modifier.height(16.dp))
            var colorState by remember { mutableIntStateOf(0) }

            val colorOptions = listOf(
                "Vermell" to Color.Red,
                "Verd" to Color.Green,
                "Blau" to Color.Blue,
                "Blanc" to Color.White,
                "Negre" to Color.Black
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        colorState = (colorState + 1) % colorOptions.size
                        viewModel.selectedColor = colorOptions[colorState].second
                    },
                    modifier = Modifier
                        .width(120.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorOptions[colorState].second)
                ) {
                    if (colorState == 3) {
                        Text(
                            colorOptions[colorState].first,
                            color = Color.Black
                        )
                    } else {
                        Text(
                            colorOptions[colorState].first,
                            color = Color.White
                        )
                    }
                }
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
    showEmail: Boolean,
    selectedIcon: ImageVector,
    showIcon: Boolean,
    enableColor: Boolean,
    selectedColor: Color
) {
    val textColor = if (enableColor) selectedColor else Color.White
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
            .height(cardHeight)
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Box {
            Image(
                painter = painterResource(id = backgroundImage),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            if (showIcon) {
                Icon(
                    imageVector = selectedIcon,
                    contentDescription = "Icona personalitzada",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                        .size(48.dp),
                    tint = textColor
                )
            }

            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(20.dp)
            ) {
                if (showName) Text(name, color = textColor, fontSize = 40.sp, fontWeight = FontWeight.Bold)
                if (showPosition) Text(position, color = textColor, fontSize = 30.sp)
                if (showDescription) Text(description, color = textColor, fontSize = 16.sp)
                if (showPhone) Text(phone, color = textColor, fontSize = 20.sp)
                if (showEmail) Text(email, color = textColor, fontSize = 20.sp)
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
