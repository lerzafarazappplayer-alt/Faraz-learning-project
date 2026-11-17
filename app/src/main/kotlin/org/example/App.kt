package org.example

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Faraz's Kotlin + Jetpack Compose Playground (App.kt)
 * Edit any UI code inside App(), push to GitHub, and download the Debug APK from Actions!
 */
@Composable
fun App() {
    var isPlaying by remember { mutableStateOf(false) }
    var volumeLevel by remember { mutableStateOf(0.7f) }
    var sliderPosition by remember { mutableStateOf(45f) }
    var notificationsEnabled by remember { mutableStateOf(true) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF1E1E2C),
                            Color(0xFF0F0F1A)
                        )
                    )
                )
                .statusBarsPadding()
                .navigationBarsPadding()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // 1. ہیڈر سیکشن (Header)
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "خوش آمدید، فراز!",
                                color = Color.White,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "آج کا میوزک اور ڈیش بورڈ سیشن",
                                color = Color(0xFFA0A0AB),
                                fontSize = 14.sp
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF6200EE)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "ف",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        }
                    }
                }

                // 2. مین پلیئر کارڈ (Player Card)
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(24.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF262638))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "لرزا پلیئر - 300% بوسٹ",
                                color = Color(0xFFBB86FC),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "فراز کی تخلیق کردہ شاندار ایپ",
                                color = Color.Gray,
                                fontSize = 12.sp
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Slider(
                                value = sliderPosition,
                                onValueChange = { sliderPosition = it },
                                valueRange = 0f..100f,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "01:23", color = Color.LightGray, fontSize = 12.sp)
                                Text(text = "03:45", color = Color.LightGray, fontSize = 12.sp)
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Button(
                                onClick = { isPlaying = !isPlaying },
                                shape = CircleShape,
                                contentPadding = PaddingValues(0.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBB86FC)),
                                modifier = Modifier.size(64.dp)
                            ) {
                                Text(
                                    text = if (isPlaying) "⏸" else "▶",
                                    fontSize = 22.sp,
                                    color = Color.Black
                                )
                            }
                        }
                    }
                }

                // 3. سیٹنگز کارڈ (Settings Card)
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF262638))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Text(
                                text = "ایپ کی ترتیبات",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "آواز کا والیم", color = Color.LightGray)
                                Text(text = "${(volumeLevel * 100).toInt()}%", color = Color(0xFFBB86FC))
                            }
                            Slider(
                                value = volumeLevel,
                                onValueChange = { volumeLevel = it },
                                modifier = Modifier.fillMaxWidth()
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "نوٹیفیکیشنز آن رکھیں", color = Color.LightGray)
                                Switch(
                                    checked = notificationsEnabled,
                                    onCheckedChange = { notificationsEnabled = it }
                                )
                            }
                        }
                    }
                }

                // 4. فوٹر (Footer)
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "ٹیکنالوجی سے محبت اور خود اعتمادی کے ساتھ",
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}
