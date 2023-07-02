package com.example.footballmatches.data.database

import com.example.footballmatches.data.models.MatchDto
import com.example.footballmatches.domain.MatchEntity

class MatchMapper {

    private fun mapMatchDtoToDbModel(dto: MatchDto) = MatchDbModel(
        matchId = dto.matchId,
        countryName = dto.countryName,
        leagueName = dto.leagueName,
        matchDate = dto.matchDate,
        matchStatus = dto.matchStatus,
        matchTime = dto.matchTime,
        matchHomeTeamId = dto.matchHomeTeamId,
        matchHomeTeamName = dto.matchHomeTeamName,
        matchHomeTeamScore = dto.matchHomeTeamScore,
        matchAwayTeamName = dto.matchAwayTeamName,
        matchAwayTeamId = dto.matchAwayTeamId,
        matchAwayTeamScore = dto.matchAwayTeamScore,
        teamHomeBadge = dto.teamHomeBadge,
        teamAwayBadge = dto.teamAwayBadge,
        countryLogo = dto.countryLogo
    )

    private fun mapMatchDbModelToEntity(dbModel: MatchDbModel) = MatchEntity(
        matchId = dbModel.matchId,
        countryName = dbModel.countryName,
        leagueName = dbModel.leagueName,
        matchDate = dbModel.matchDate,
        matchStatus = dbModel.matchStatus,
        matchTime = dbModel.matchTime,
        matchHomeTeamId = dbModel.matchHomeTeamId,
        matchHomeTeamName = dbModel.matchHomeTeamName,
        matchHomeTeamScore = dbModel.matchHomeTeamScore,
        matchAwayTeamName = dbModel.matchAwayTeamName,
        matchAwayTeamId = dbModel.matchAwayTeamId,
        matchAwayTeamScore = dbModel.matchAwayTeamScore,
        teamHomeBadge = dbModel.teamHomeBadge,
        teamAwayBadge = dbModel.teamAwayBadge,
        countryLogo = dbModel.countryLogo
    )

    fun mapListMatchDtoToDbModel(dto: List<MatchDto>) = dto.map {
        mapMatchDtoToDbModel(it)
    }

    fun mapListMatchDbModelToEntity(dbModel: List<MatchDbModel>) = dbModel.map {
        mapMatchDbModelToEntity(it)
    }
}