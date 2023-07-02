package com.example.footballmatches.di

import android.app.Application
import com.example.footballmatches.data.database.AppDatabase
import com.example.footballmatches.data.database.MatchDao
import com.example.footballmatches.data.models.APIError
import com.example.footballmatches.data.network.ApiFactory
import com.example.footballmatches.data.network.ApiService
import com.example.footballmatches.data.repository.RepositoryImpl
import com.example.footballmatches.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.ResponseBody
import retrofit2.Converter

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindRepository(impl: RepositoryImpl): Repository

    companion object {

        @Provides
        @ApplicationScope
        fun provideMatchDao(
            application: Application
        ): MatchDao {
            return AppDatabase.getInstance(application).matchDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

        @Provides
        @ApplicationScope
        fun provideErrorConverter(): Converter<ResponseBody, APIError> {
            return ApiFactory.errorConverter
        }
    }
}