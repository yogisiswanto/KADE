package com.yogisiswanto.submission2.View

import com.yogisiswanto.submission2.Model.Event

interface MainView {

    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Event>)
}