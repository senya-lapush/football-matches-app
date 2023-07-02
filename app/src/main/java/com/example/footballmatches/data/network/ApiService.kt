package com.example.footballmatches.data.network

import com.example.footballmatches.data.models.MatchDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("?action=get_events")
    suspend fun getMatches(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "",
        @Query(QUERY_PARAM_DATE_FROM) dateFrom: String = "",
        @Query(QUERY_PARAM_DATE_TO) dateTo: String = "",
        @Query(QUERY_PARAM_TIMEZONE) timezone: String = "",
    ): Response<List<MatchDto>>

    companion object {
        private const val QUERY_PARAM_DATE_FROM = "from"
        private const val QUERY_PARAM_DATE_TO = "to"
        private const val QUERY_PARAM_API_KEY = "APIkey"
        private const val QUERY_PARAM_TIMEZONE = "timezone"
    }
}