package com.example.myapplication.apis

import com.example.myapplication.responses.ApiResponse
import com.example.myapplication.responses.ApiResponseSignup
import com.google.gson.annotations.SerializedName

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("users/api/login/")
    suspend fun login(
        @Body requestBody : RequestBody
    ) :Response<ApiResponse>
    @POST("users/api/signup/")
    suspend fun signup(
        @Body requestBodyResponse : RequestBodyResponse
    ) :Response<ApiResponseSignup>

    @POST("users/api/user_verification/")
    suspend fun verify(
        @Body requestBodyForVerify: RequestBodyForVerify
    ) :Response<ApiResponse>
}

data class RequestBody(
    @SerializedName("phone_number") val phoneNumber: String,
    @SerializedName("password") val password: String
)

data class RequestBodyResponse(
    @SerializedName("phone_number") val phoneNumber: String
)
data class RequestBodyForVerify(
    @SerializedName("phone_number") val phoneNumber: String,
    @SerializedName("verification_code") val verificationCode: String,
    @SerializedName("password1") val password1: String,
    @SerializedName("password2") val password2: String
)
