package com.example.footballmatches.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MatchDao {

    @Query("SELECT * FROM matches")
    suspend fun getMatches(): List<MatchDbModel>

    suspend fun updateMatches(matches: List<MatchDbModel>) {
        deleteMatches()
        insertMatches(matches)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatches(matches: List<MatchDbModel>)

    @Query("DELETE FROM matches")
    suspend fun deleteMatches()
}