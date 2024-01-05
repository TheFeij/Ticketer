package com.example.myapplication.pages

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.models.Gender
import com.example.myapplication.models.Passenger
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPassengerPage(
    navController: NavHostController,
    passengers: ArrayList<Passenger>,
    passenger: Passenger?,
    modifier: Modifier = Modifier,
) {
    val editMode: Boolean = passenger != null

    var buttonText: String = "افزودن مسافر"
    if (editMode) {
        buttonText = "ویرایش مسافر"
    }

    var passengerName by remember { mutableStateOf(passenger?.name ?: "") }
    // TODO: change birthday to persian format, also change it to: passenger.birthDate
    var passengerBirthday by remember { mutableStateOf(LocalDate.now()) }
    var passengerId by remember { mutableStateOf(passenger?.nationalCode ?: "") }
    var isMale by remember { mutableStateOf((passenger?.gender ?: Gender.MALE) == Gender.MALE) }
    var isFemale by remember { mutableStateOf((passenger?.gender ?: Gender.MALE) == Gender.FEMALE) }

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
            ){
                // Name
                OutlinedTextField(
                    value = passengerName,
                    onValueChange = { passengerName = it },
                    label = { Text("نام") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(8.dp),
//                        .padding(vertical = 8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true,
                    colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                        textColor = Color.White,
                    ),
                )
                // Name
                OutlinedTextField(
                    value = passengerName,
                    onValueChange = { passengerName = it },
                    label = { Text("نام خانوادگی") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(8.dp),
//                        .padding(vertical = 8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true,
                    colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                        textColor = Color.White,
                    ),
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                // Name
                OutlinedTextField(
                    value = passengerName,
                    onValueChange = { passengerName = it },
                    label = { Text("نام به انگلیسی") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(8.dp),
//                        .padding(vertical = 8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true,
                    colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                        textColor = Color.White,
                    ),
                )
                // Name
                OutlinedTextField(
                    value = passengerName,
                    onValueChange = { passengerName = it },
                    label = { Text("نام خانوادگی به انگلیسی") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(8.dp),
//                        .padding(vertical = 8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true,
                    colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                        textColor = Color.White,
                    ),
                )
            }
            // ID
            OutlinedTextField(
                value = passengerId,
                onValueChange = { passengerId = it },
                label = { Text("کد ملی") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(vertical = 8.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                singleLine = true,
                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                ),
            )

            // Gender
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                        .padding(vertical = 8.dp),
                ) {
                    GenderCheckbox("مرد", isMale) { isMale = it }
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                        .padding(vertical = 8.dp),
                ) {
                    GenderCheckbox("زن", isFemale) { isFemale = it }
                }
            }

            // Birthday
            // Date Picker
            Column {
                Text(
                    text = "تاریخ تولد:",
                    style = TextStyle(color = Color.White),
                    modifier = modifier
                        .padding(vertical = 16.dp)
                        .padding(horizontal = 5.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                            .padding(vertical = 8.dp),
                    ) {
                        Spinner(
                            items = (1..31).map { it.toString() },
                            selectedItem = passengerBirthday.dayOfMonth.toString(),
                            onItemSelected = {
                                passengerBirthday = passengerBirthday.withDayOfMonth(it.toInt())
                            },
                            label = "روز"
                        )
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                            .padding(vertical = 8.dp),
                    ) {
                        Spinner(
                            items = (1..12).map { it.toString() },
                            selectedItem = passengerBirthday.monthValue.toString(),
                            onItemSelected = {
                                passengerBirthday = passengerBirthday.withMonth(it.toInt())
                            },
                            label = "ماه"
                        )
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                            .padding(vertical = 8.dp),
                    ) {
                        Spinner(
                            items = (1340..1402).map { it.toString() },
                            selectedItem = passengerBirthday.year.toString(),
                            onItemSelected = {
                                passengerBirthday = passengerBirthday.withYear(it.toInt())
                            },
                            label = "سال"
                        )
                    }
                }
            }

            // Save Button
            Button(
                onClick = {
                    val gender: Gender = if (isMale) {
                        Gender.MALE
                    } else {
                        Gender.FEMALE
                    }

                    if (!editMode) {
                        val newPassenger =
                            Passenger(
                                passengerName,
                                passengerId,
                                gender,
                                passengerBirthday.toString()
                            )
                        passengers.add(newPassenger)
                    } else {
                        val editingPassenger =
                            passengers.find { it.nationalCode == passengerId }

                        editingPassenger?.name = passengerName
                        editingPassenger?.nationalCode = passengerId
                        editingPassenger?.gender = gender
                        editingPassenger?.birthDate = passengerBirthday.toString()
                    }

                    navController.navigate("passengersList")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(vertical = 8.dp),
            ) {
                Text(buttonText)
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Spinner(
    items: List<String>,
    selectedItem: String,
    onItemSelected: (String) -> Unit,
    label: String
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        TextField(
            value = selectedItem,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier.menuAnchor(),
            label = { Text(label) } // Set the label here
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun GenderCheckbox(label: String, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp)
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { onCheckedChange(it) },
            modifier = Modifier
                .size(24.dp)
                .padding(end = 8.dp)
        )
        Text(
            text = label,
            style = TextStyle(color = Color.White),
            modifier = Modifier.clickable { onCheckedChange(!isChecked) }
        )
    }
}
