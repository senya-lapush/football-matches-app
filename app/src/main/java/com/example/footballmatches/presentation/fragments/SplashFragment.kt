package com.example.footballmatches.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.footballmatches.databinding.FragmentSplashBinding
import com.example.footballmatches.domain.NetworkResult
import com.example.footballmatches.presentation.MainActivity
import com.example.footballmatches.presentation.MatchApp
import com.example.footballmatches.presentation.MatchViewModel
import com.example.footballmatches.presentation.ViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashFragment : Fragment() {

    private lateinit var viewModel: MatchViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: FragmentSplashBinding? = null
    private val binding: FragmentSplashBinding
        get() = _binding ?: throw RuntimeException("FragmentSplashBinding is null")

    private val component by lazy {
        (requireActivity().application as MatchApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[MatchViewModel::class.java]
        viewModel.loadMatches()
        viewModel.matches.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Success -> {
                    (activity as MainActivity).launchMatchFragment()
                }
                is NetworkResult.Error -> {
                    (activity as MainActivity).launchMatchFragment()
                }
                is NetworkResult.Loading -> {

                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance() = SplashFragment()
    }
}