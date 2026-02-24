package com.example.cs501ia3p2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.compose.ui.tooling.preview.Preview
import com.example.cs501ia3p2.ui.theme.CS501IA3P2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CS501IA3P2Theme {
                ProfileScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") }
            )
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {

            /* ---------------- HEADER BACKGROUND ---------------- */

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.8f)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.TopCenter
            ) {

                /* ---------------- AVATAR ---------------- */

                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .align(Alignment.BottomCenter)
                        .offset(y = 60.dp)
                        .zIndex(1f)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile Avatar",
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier
                            .size(60.dp)
                            .align(Alignment.Center)
                    )
                }
            }

            /* ---------------- OVERLAY PROFILE CARD ---------------- */

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = 160.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 80.dp, bottom = 24.dp, start = 24.dp, end = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Shrey Devkar",
                        style = MaterialTheme.typography.titleLarge
                    )

                    Text(
                        text = "Computer Science Student",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    AssistChip(
                        onClick = { },
                        label = { Text("Boston University") }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        FilledTonalButton(onClick = { }) {
                            Text("Follow")
                        }

                        Button(onClick = { }) {
                            Text("Message")
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Badge(
                        containerColor = MaterialTheme.colorScheme.secondary
                    ) {
                        Text("PRO")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfile() {
    CS501IA3P2Theme {
        ProfileScreen()
    }
}