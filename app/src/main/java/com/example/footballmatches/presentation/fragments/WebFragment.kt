package com.example.footballmatches.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.footballmatches.R
import com.example.footballmatches.databinding.FragmentSplashBinding
import com.example.footballmatches.databinding.FragmentWebBinding

class WebFragment : Fragment() {

    private var _binding: FragmentWebBinding? = null
    private val binding: FragmentWebBinding
        get() = _binding ?: throw RuntimeException("FragmentWebBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val wb = binding.webView
        wb.webViewClient = WebViewClient()
        wb.loadUrl(URL)
        wb.settings.javaScriptEnabled = true
        wb.settings.domStorageEnabled = true
        wb.settings.supportZoom()
    }

    companion object {
        private const val URL = "https://www.skysports.com/football/news"
        fun newInstance() = WebFragment()
    }
}