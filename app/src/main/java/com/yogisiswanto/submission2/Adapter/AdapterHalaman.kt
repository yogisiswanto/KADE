package com.yogisiswanto.submission2.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.yogisiswanto.submission2.View.Activity.LastMatchFragment
import com.yogisiswanto.submission2.View.Activity.NextMatchFragment

class AdapterHalaman(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val pageFragment: List<Fragment> =   listOf(LastMatchFragment(), NextMatchFragment())

    override fun getItem(position: Int): Fragment {

        return pageFragment[position]
    }

    override fun getCount(): Int {

        return pageFragment.size
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return when(position){
            0   ->  "Last Match"
            else   ->  "Next Match"
        }
    }
}