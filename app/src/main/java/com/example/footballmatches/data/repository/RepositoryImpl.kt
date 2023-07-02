package com.example.footballmatches.data.repository

import android.app.Application
import android.icu.text.SimpleDateFormat
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.footballmatches.data.database.AppDatabase
import com.example.footballmatches.data.database.MatchMapper
import com.example.footballmatches.data.network.ApiFactory
import com.example.footballmatches.domain.MatchEntity
import com.example.footballmatches.domain.NetworkResult
import com.example.footballmatches.domain.Repository
import java.util.*

class RepositoryImpl(private val application: Application) : Repository {

    private val _matches = MutableLiveData<NetworkResult<List<MatchEntity>>>()
    override val matches: LiveData<NetworkResult<List<MatchEntity>>>
        get() = _matches

    private val matchDao = AppDatabase.getInstance(application).matchDao()
    private val apiService = ApiFactory.apiService
    private val errorConverter = ApiFactory.errorConverter
    private val mapper = MatchMapper()

    override suspend fun loadMatches() {
        _matches.postValue(NetworkResult.Loading())
        val dateToday = getDateString()
        val response = apiService.getMatches(
            apiKey = API_KEY,
            dateFrom = dateToday,
            dateTo = dateToday,
            timezone = TIMEZONE
        )
        if (response.isSuccessful && response.body() != null) {
            Log.d(javaClass.simpleName.toString(), response.body()!!.toString())
            val matchListDbModel = mapper.mapListMatchDtoToDbModel(response.body()!!)
            matchDao.updateMatches(matchListDbModel)

            val matchListEntity = mapper.mapListMatchDbModelToEntity(matchDao.getMatches())
            _matches.postValue(NetworkResult.Success(matchListEntity))
        } else if (response.errorBody() != null) {
            val apiError = errorConverter.convert(response.errorBody()!!)
            val matchListEntity = mapper.mapListMatchDbModelToEntity(matchDao.getMatches())
            _matches.postValue(NetworkResult.Error(apiError?.message, matchListEntity))
        } else {
            _matches.postValue(NetworkResult.Error("Something went wrong..."))
        }
    }

    private fun getDateString(): String {
        val sdf = SimpleDateFormat(DATE_PATTERN, Locale.getDefault())
        val c = Calendar.getInstance()
        return sdf.format(c.time)
    }

    companion object {
        private const val API_KEY = "3c783e514119908b24b5fde2c97ffcc97eb0443b5938af11f65405e6120c8a91"
        private const val DATE_PATTERN = "yyyy-MM-dd"
        private const val TIMEZONE = "Europe\\/Moscow"
    }
}