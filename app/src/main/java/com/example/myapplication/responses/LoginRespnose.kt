package com.example.myapplication.responses

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("data")
    val data: Data?,
    @SerializedName("error")
    val error: Error?
)

data class ApiResponseSignup(
    @SerializedName("data")
    val data: Data?,
    @SerializedName("error")
    val error: Error?
)
data class Data(
    @SerializedName("phone_number")
    val phoneNumber: String?
)

data class Error(
    @SerializedName("credentials")
    val credentials: String?
)
