package com.example.footballmatches.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.footballmatches.R
import com.example.footballmatches.databinding.FragmentMatchesBinding
import com.example.footballmatches.domain.NetworkResult
import com.example.footballmatches.presentation.MatchAdapter
import com.example.footballmatches.presentation.MatchViewModel
import com.google.android.material.snackbar.Snackbar

class MatchesFragment : Fragment() {

    private var _binding: FragmentMatchesBinding? = null
    private val binding: FragmentMatchesBinding
        get() = _binding ?: throw RuntimeException("FragmentMatchesBinding is null")

    private lateinit var viewModel: MatchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMatchesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MatchViewModel::class.java]
        binding.btnSite.setOnClickListener {
            launchWebFragment()
        }
        val adapter = MatchAdapter(requireActivity())
        binding.rvMatches.adapter = adapter
        viewModel.matches.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Success -> {
                    adapter.list = it.data!!
                }
                is NetworkResult.Error -> {
                    if (it.data != null) {
                        adapter.list = it.data
                    }
                }
                is NetworkResult.Loading -> {
                    Snackbar.make(binding.root, "Loading...", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun launchWebFragment() {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, WebFragment.newInstance())
            .addToBackStack("MatchesFragment")
            .commit()
    }

    companion object {
        fun newInstance() = MatchesFragment()
    }
}