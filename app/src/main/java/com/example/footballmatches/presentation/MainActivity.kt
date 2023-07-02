package com.example.footballmatches.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.footballmatches.R
import com.example.footballmatches.databinding.ActivityMainBinding
import com.example.footballmatches.presentation.fragments.MatchesFragment
import com.example.footballmatches.presentation.fragments.SplashFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, SplashFragment.newInstance())
                .commit()
        }
    }

    fun launchMatchFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, MatchesFragment.newInstance())
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putBoolean("matchFragmentLaunched", true)
    }
}