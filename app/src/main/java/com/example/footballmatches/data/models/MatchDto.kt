package com.example.footballmatches.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MatchDto(
    @SerializedName("match_id")
    @Expose
    val matchId: Long,
    @SerializedName("country_name")
    @Expose
    val countryName: String,
    @SerializedName("league_name")
    @Expose
    val leagueName: String,
    @SerializedName("match_date")
    @Expose
    val matchDate: String,
    @SerializedName("match_status")
    @Expose
    val matchStatus: String?,
    @SerializedName("match_time")
    @Expose
    val matchTime: String,
    @SerializedName("match_hometeam_id")
    @Expose
    val matchHomeTeamId: Long,
    @SerializedName("match_hometeam_name")
    @Expose
    val matchHomeTeamName: String,
    @SerializedName("match_hometeam_score")
    @Expose
    val matchHomeTeamScore: String,
    @SerializedName("match_awayteam_name")
    @Expose
    val matchAwayTeamName: String,
    @SerializedName("match_awayteam_id")
    @Expose
    val matchAwayTeamId: Long,
    @SerializedName("match_awayteam_score")
    @Expose
    val matchAwayTeamScore: String,
    @SerializedName("team_home_badge")
    @Expose
    val teamHomeBadge: String?,
    @SerializedName("team_away_badge")
    @Expose
    val teamAwayBadge: String?,
    @SerializedName("country_logo")
    @Expose
    val countryLogo: String?
)