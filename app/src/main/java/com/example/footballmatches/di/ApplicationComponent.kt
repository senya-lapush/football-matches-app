package com.example.footballmatches.di

import android.app.Application
import com.example.footballmatches.presentation.fragments.MatchesFragment
import com.example.footballmatches.presentation.fragments.SplashFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: SplashFragment)
    fun inject(fragment: MatchesFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}