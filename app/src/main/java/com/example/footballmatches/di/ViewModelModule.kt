package com.example.footballmatches.di

import androidx.lifecycle.ViewModel
import com.example.footballmatches.presentation.MatchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MatchViewModel::class)
    fun bindMatchViewModel(viewModel: MatchViewModel): ViewModel
}