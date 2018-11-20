package com.yogisiswanto.submission2.View.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yogisiswanto.submission2.R
import kotlinx.android.synthetic.main.activity_main.*
import com.yogisiswanto.submission2.Adapter.AdapterHalaman

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = AdapterHalaman(supportFragmentManager)
        slidingTab.setupWithViewPager(viewPager)
    }
}
