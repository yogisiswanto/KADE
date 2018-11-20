package com.yogisiswanto.submission2.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yogisiswanto.submission2.Model.Event
import com.yogisiswanto.submission2.R
import kotlinx.android.synthetic.main.match_ui.view.*
import kotlinx.android.extensions.LayoutContainer

class MainAdapter(private val events: List<Event>)
    : RecyclerView.Adapter<MainAdapter.TeamViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {

        return TeamViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.match_ui, parent, false))
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {

        holder.bindItem(events[position])
    }


    class TeamViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindItem(teams: Event) {

            itemView.strHomeTeam.text = teams.strHomeTeam
            itemView.strAwayTeam.text = teams.strAwayTeam
            itemView.homeScore.text = teams.intHomeScore
            itemView.awayScore.text = teams.intAwayScore

        }

    }
}
