package com.yogisiswanto.submission2.View.Activity


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.google.gson.Gson
import com.yogisiswanto.submission2.API.ApiRespository
import com.yogisiswanto.submission2.Adapter.MainAdapter
import com.yogisiswanto.submission2.Model.Event
import com.yogisiswanto.submission2.Presenter.MainPresenter

import com.yogisiswanto.submission2.R
import com.yogisiswanto.submission2.Utils.invisble
import com.yogisiswanto.submission2.Utils.visible
import com.yogisiswanto.submission2.View.MainView
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.onRefresh

/**
 * A simple [Fragment] subclass.
 *
 */
class LastMatchFragment : Fragment(), MainView {

    private var teams:  MutableList<Event> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter
    private lateinit var league: String
    private lateinit var progressBar: ProgressBar
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var swipeRefresh: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View      = inflater.inflate(R.layout.fragment_last_match, container, false)

        mRecyclerView   =   view.findViewById(R.id.listTeam)
        progressBar     =   view.findViewById(R.id.progressBar)
        swipeRefresh    =   view.findViewById(R.id.swipeRefresh)


        mRecyclerView.layoutManager = LinearLayoutManager(this.context)
        adapter             =   MainAdapter(teams)
        mRecyclerView.adapter    =   adapter
        league              =   "4335"

        val request         =   ApiRespository()
        val gson            =   Gson()
        presenter           =   MainPresenter(this, request, gson)
        presenter.getTeamList(league)

        swipeRefresh.onRefresh {

            presenter.getTeamList(league)
        }

        // Inflate the layout for this fragment
        return view
    }

    override fun showLoading() {

        progressBar.visible()
    }

    override fun hideLoading() {

        progressBar.invisble()
    }

    override fun showTeamList(data: List<Event>) {

        swipeRefresh.isRefreshing   =   false
        teams.clear()
        teams.addAll(data)
        adapter.notifyDataSetChanged()
    }




}
