package com.example.footballmatches.data.network

import com.example.footballmatches.data.models.APIError
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL = "https://apiv3.apifootball.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
    val errorConverter: Converter<ResponseBody, APIError> = retrofit.responseBodyConverter(
        APIError::class.java,
        arrayOfNulls<Annotation>(0)
    )
}