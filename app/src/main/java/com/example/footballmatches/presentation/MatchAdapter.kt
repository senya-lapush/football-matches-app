package com.example.footballmatches.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.footballmatches.R
import com.example.footballmatches.databinding.ItemMatchInfoBinding
import com.example.footballmatches.domain.MatchEntity

class MatchAdapter(private val context: Context) :
    RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    class MatchViewHolder(val binding: ItemMatchInfoBinding): RecyclerView.ViewHolder(binding.root)

    var list: List<MatchEntity> = listOf()
        set(value) {
        field = value
        notifyItemRangeChanged(0, list.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val binding = ItemMatchInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MatchViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val match = list[position]
        val scoreTemplate = context.resources.getString(R.string.match_score)
        val requestOptions = RequestOptions().apply {
            error(R.drawable.icon)
            placeholder(R.drawable.icon)
        }
        with(holder.binding) {
            with(match) {
                tvCountry.text = countryName
                tvLeagueName.text = leagueName
                tvHomeTeamName.text = matchHomeTeamName
                tvAwayTeamName.text = matchAwayTeamName
                tvMatchScoreOrTime.text =
                    if (matchHomeTeamScore != "" || matchAwayTeamScore != "") {
                        String.format(scoreTemplate, matchHomeTeamScore, matchAwayTeamScore)
                    } else {
                        matchTime
                    }
                tvStatus.text = matchStatus
                Glide.with(context)
                    .load(teamHomeBadge)
                    .apply(requestOptions)
                    .into(ivHomeTeamBadge)
                Glide.with(context)
                    .load(teamAwayBadge)
                    .apply(requestOptions)
                    .into(ivAwayTeamBadge)
            }
        }
    }
}