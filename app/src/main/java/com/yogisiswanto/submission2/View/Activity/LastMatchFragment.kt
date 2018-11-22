/*
 *  Name Class      : LastMatchFragment
 *  Author          : Yogi Siswanto
 *  Email           : yogisiswanto.c2@gmail.com
 *  Language        : Kotlin
 *  Description     : The Fragment Activity for Last Match TabLayout
 */

package com.yogisiswanto.submission2.View.Activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.yogisiswanto.submission2.API.ApiRespository
import com.yogisiswanto.submission2.Adapter.MainAdapter
import com.yogisiswanto.submission2.Model.Event
import com.yogisiswanto.submission2.Presenter.MainPresenter

import com.yogisiswanto.submission2.R
import com.yogisiswanto.submission2.Utils.invisble
import com.yogisiswanto.submission2.Utils.visible
import com.yogisiswanto.submission2.View.MainView
import org.jetbrains.anko.support.v4.onRefresh
import kotlinx.android.synthetic.main.fragment_last_match.*

//Class LastMatchFragment
class LastMatchFragment : Fragment(), MainView {

    //variable instantiation
    private var teams: MutableList<Event> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter
    private lateinit var league: String

    //creating Fragment Layout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_last_match, container, false)
    }


    //when activity created, accessing data from API
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //RecyclerView.LayoutManager instantiation
        listTeam.layoutManager = LinearLayoutManager(context)

        //RecyclerView adapter instantiation
        adapter = MainAdapter(teams)
        listTeam.adapter = adapter

        //instantiation Id League
        league = "4335"

        //local variable instantiation
        val request = ApiRespository()
        val gson = Gson()

        //Presenter instantiation
        presenter = MainPresenter(this, request, gson)

        //accessing The API from presenter
        presenter.get15LastEventsList(league)


        //when SwipeRefresh is pull, the data will be call
        swipeRefresh.onRefresh {

            presenter.get15LastEventsList(league)
        }

    }

    //show loading
    override fun showLoading() {

        progressBar.visible()
    }

    //hidden loading
    override fun hideLoading() {

        progressBar.invisble()
    }

    //show data from API
    override fun showEventList(data: List<Event>) {

        swipeRefresh.isRefreshing = false
        teams.clear()
        teams.addAll(data)
        adapter.notifyDataSetChanged()
    }
}
