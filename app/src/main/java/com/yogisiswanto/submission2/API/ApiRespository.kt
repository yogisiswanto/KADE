package com.yogisiswanto.submission2.API

import java.net.URL

class ApiRespository {

    fun doRequest(url: String): String{

        return URL(url).readText()
    }
}