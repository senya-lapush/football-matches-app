package com.example.footballmatches.domain

data class MatchEntity(
    val matchId: Long,
    val countryName: String,
    val leagueName: String,
    val matchDate: String,
    val matchStatus: String? = null,
    val matchTime: String,
    val matchHomeTeamId: Long,
    val matchHomeTeamName: String,
    val matchHomeTeamScore: String? = null,
    val matchAwayTeamName: String,
    val matchAwayTeamId: Long,
    val matchAwayTeamScore: String? = null,
    val teamHomeBadge: String? = null,
    val teamAwayBadge: String? = null,
    val countryLogo: String? = null
)
