package com.example.footballmatches.data.models

import com.google.gson.annotations.SerializedName

data class APIError(
    @SerializedName("error")
    val code: Int?,
    @SerializedName("message")
    val message: String?
)