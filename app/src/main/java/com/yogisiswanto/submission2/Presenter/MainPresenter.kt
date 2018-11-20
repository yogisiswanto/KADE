package com.yogisiswanto.submission2.Presenter

import android.util.Log
import com.google.gson.Gson
import com.yogisiswanto.submission2.API.ApiRespository
import com.yogisiswanto.submission2.API.TheSportDBApi
import com.yogisiswanto.submission2.Model.TeamResponse
import com.yogisiswanto.submission2.View.MainView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(
    private val view: MainView,
    private val apiRespository: ApiRespository,
    private val gson: Gson)
{

    fun getTeamList(league: String?){

//        Log.w("League", league)
//        println("asdasdasdasdasdasdadasdasdasdasdasdadsasdasd "+league)
        view.showLoading()

        doAsync {

            val data    =   gson.fromJson(
                apiRespository.doRequest(TheSportDBApi.getTeams(league)),

                TeamResponse::class.java
            )
            println("asdasdasd"+data)
            uiThread {
                view.hideLoading()
                view.showTeamList(data.events)
            }
        }
    }
}