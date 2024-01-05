package com.example.myapplication.pages

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomePage(navController: NavHostController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.Black)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = modifier.weight(1f),
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .padding(horizontal = 32.dp),
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier.weight(1.5f),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(16.dp)
                    .padding(horizontal = 16.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(3f),
                ) {
                    Text(
                        text = "موجودی:",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        style = TextStyle(
                            color = Color.Black,
                        ),
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = "13600",
                        modifier = Modifier
                            .fillMaxWidth(),
                        style = TextStyle(
                            color = Color.Black,
                        ),
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .padding(horizontal = 16.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f),
                    ) {
                        Button(
                            onClick = {
                                navController.navigate("reserve")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .padding(horizontal = 8.dp)
                        ) {
                            Text("رزرو")
                        }
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f),
                    ) {
                        Button(
                            onClick = {
                                navController.navigate("passengersList")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .padding(horizontal = 8.dp)
                        ) {
                            Text("مسافران")
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .weight(1f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f),
                    ) {
                        Button(
                            onClick = {
                                navController.navigate("charge")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .padding(horizontal = 8.dp)
                        ) {
                            Text("افزایش اعتبار")
                        }
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f),
                    ) {
                        Button(
                            onClick = {
                                navController.navigate("ticketsList")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .padding(horizontal = 8.dp)
                        ) {
                            Text("بلیط ها")
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .weight(1f),
                ) {
                    Button(
                        onClick = {
                            navController.navigate("startup")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .padding(horizontal = 8.dp),
                    ) {
                        Text("خروج")
                    }
                }
            }
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = modifier.weight(1f),
        ) {
            Button(
                onClick = {
                    navController.navigate("aboutUs")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(horizontal = 8.dp)
            ) {
                Text("درباره ی ما")
            }
        }
    }
}
