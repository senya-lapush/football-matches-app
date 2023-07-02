package com.example.footballmatches.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matches")
data class MatchDbModel(
    @PrimaryKey
    val matchId: Long,
    val countryName: String,
    val leagueName: String,
    val matchDate: String,
    val matchStatus: String?,
    val matchTime: String,
    val matchHomeTeamId: Long,
    val matchHomeTeamName: String,
    val matchHomeTeamScore: String?,
    val matchAwayTeamName: String,
    val matchAwayTeamId: Long,
    val matchAwayTeamScore: String?,
    val teamHomeBadge: String?,
    val teamAwayBadge: String?,
    val countryLogo: String?
)
