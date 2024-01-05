package com.example.myapplication.pages

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.apis.ApiService
import com.example.myapplication.apis.RequestBodyForVerify
import com.example.myapplication.apis.RequestBodyResponse
import com.example.myapplication.apis.RetrofitInstance
import com.example.myapplication.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

var phone = ""

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupPage(navController: NavHostController, modifier: Modifier = Modifier) {
    val retrofit = RetrofitInstance.getRetrofitInstance()
    val apiService = retrofit.create(ApiService::class.java)
    var phoneNumber by remember { mutableStateOf("") }

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
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("شماره تلفن") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(horizontal = 8.dp),
                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                ),
            )
            phone = phoneNumber

            fun apiCall() {
                val number = phoneNumber

                Log.i("ticket", phoneNumber)
                val body = RequestBodyResponse(number)
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val response = apiService.signup(body)

                        if (response.isSuccessful) {
                            withContext(Dispatchers.Main) {
                                navController.navigate("followUp")

                            }
                            Log.i("ticket", "haaaaa")
                        } else {
                            response.errorBody()?.string()?.let { Log.i("ticket", it) }
                            val error = response.body()?.error?.credentials
                            Log.i("ticket", error.toString())
                        }
                    } catch (e: Exception) {
                        Log.i("ticket", "exception happened")
                        Log.e("ticket", e.message.toString())
                    }
                }
            }

            Button(
                onClick = {
                    apiCall()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(horizontal = 8.dp)
            ) {
                Text("ادامه")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FollowUp(navController: NavHostController, modifier: Modifier = Modifier) {
    val retrofit = RetrofitInstance.getRetrofitInstance()
    val apiService = retrofit.create(ApiService::class.java)
    var pass by remember { mutableStateOf("") }
    var passAgain by remember { mutableStateOf("") }
    var code by remember { mutableStateOf("") }
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
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = pass,
                onValueChange = { pass = it },
                label = { Text("رمز") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(horizontal = 8.dp),
                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                ),
            )

            OutlinedTextField(
                value = passAgain,
                onValueChange = { passAgain = it },
                label = { Text("تکرار رمز") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(horizontal = 8.dp),
                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                ),
            )

            OutlinedTextField(
                value = code,
                onValueChange = { code = it },
                label = { Text("کد اعتبار سنجی") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(horizontal = 8.dp),
                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                ),
            )

            fun apiCallForNext() {
                val body = RequestBodyForVerify(phone, code, pass, passAgain)
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val response = apiService.verify(body)

                        if (response.isSuccessful) {
                            withContext(Dispatchers.Main) {
                                navController.navigate("home")


                            }
                            Log.i("ticket", "haaaaa")
                        } else {
                            response.errorBody()?.string()?.let { Log.i("ticket", it) }
                            val error = response.body()?.error?.credentials
                            Log.i("ticket", error.toString())
                        }
                    } catch (e: Exception) {
                        Log.i("ticket", "exception happened")
                        Log.e("ticket", e.message.toString())
                    }

                }
            }

            Button(
                onClick = {
                    apiCallForNext()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(horizontal = 8.dp)
            ) {
                Text("ثبت")
            }
        }
    }
}
