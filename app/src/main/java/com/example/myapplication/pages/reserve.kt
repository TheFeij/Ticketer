package com.example.myapplication.pages

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import java.time.LocalDate
import java.time.LocalTime
import java.util.*


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TicketReservationPage(navController: NavHostController, modifier: Modifier = Modifier) {
    var source by remember { mutableStateOf("") }
    var destination by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    var selectedTime by remember { mutableStateOf(LocalTime.now()) }

    // List of cities or destinations
    val cities = listOf("تهران", "قم", "همدان", "اراک")

    Column(
        modifier = modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .padding(horizontal = 32.dp),
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center // Center vertically
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                        .padding(8.dp)
                ) {
                    Spinner(
                        items = cities,
                        selectedItem = source,
                        onItemSelected = { source = it },
                        label = "مبدا"
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                        .padding(8.dp)
                ) {
                    // Destination com.example.myapplication.Spinner
                    Spinner(
                        items = cities,
                        selectedItem = destination,
                        onItemSelected = { destination = it },
                        label = "مقصد"
                    )
                }
            }

            // Date Picker
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                        .padding(8.dp)
                ) {
                    Spinner(
                        items = (1..31).map { it.toString() },
                        selectedItem = selectedDate.dayOfMonth.toString(),
                        onItemSelected = { selectedDate = selectedDate.withDayOfMonth(it.toInt()) },
                        label = "روز"
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                        .padding(8.dp)
                ) {
                    Spinner(
                        items = (1..12).map { it.toString() },
                        selectedItem = selectedDate.monthValue.toString(),
                        onItemSelected = { selectedDate = selectedDate.withMonth(it.toInt()) },
                        label = "ماه"
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                        .padding(8.dp)
                ) {
                    Spinner(
                        items = (1402..1405).map { it.toString() },
                        selectedItem = selectedDate.year.toString(),
                        onItemSelected = { selectedDate = selectedDate.withYear(it.toInt()) },
                        label = "سال"
                    )
                }
            }

            // Time Picker
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                        .padding(8.dp)
                ) {
                    Spinner(
                        items = (0..59).map { it.toString() },
                        selectedItem = selectedTime.minute.toString(),
                        onItemSelected = { selectedTime = selectedTime.withMinute(it.toInt()) },
                        label = "دقیقه"
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                        .padding(8.dp)
                ) {
                    Spinner(
                        items = (0..23).map { it.toString() },
                        selectedItem = selectedTime.hour.toString(),
                        onItemSelected = { selectedTime = selectedTime.withHour(it.toInt()) },
                        label = "ساعت"
                    )
                }
            }

            Button(
                onClick = {},
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .padding(8.dp)
            ) {
                Text("رزرو")
            }
        }
    }
}
