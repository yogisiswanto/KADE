/*
 *  Name Class      : MainActivity
 *  Author          : Yogi Siswanto
 *  Email           : yogisiswanto.c2@gmail.com
 *  Language        : Kotlin
 *  Description     : This class is main activity
 */

package com.yogisiswanto.anko.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.yogisiswanto.anko.Item
import com.yogisiswanto.anko.R
import com.yogisiswanto.football.RecyclerViewAdapter
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

//this class is extended from AppCompatActivity
class MainActivity : AppCompatActivity() {

    //variable initialization
    private var items : MutableList<Item> = mutableListOf()

    //function for creating instance state
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //calling MainActivityUI
        MainActivityUI().setContentView(this)

        //calling RecycleView Layout
        val list = findViewById<RecyclerView>(R.id.clubList)

        //calling initData Function
        initData()

        //calling linear layout, and put into layout manager
        list.layoutManager = LinearLayoutManager(this)

        //calling RecycleView Adapter
        //input context and Items class
        //showing Description when clicked
        list.adapter = RecyclerViewAdapter(this, items){

            startActivity<SecondActivity>(
                "footBallClubName" to "${it.name}",
                "footBallClubPicture" to it.image,
                "footBallClubDescription" to "${it.description}"
            )
        }
    }

    /*
    *   @Name Method    : initData
    *   @Description    : Calling string name,image and description from res to class Item
    */
    private fun initData(){

        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val description = resources.getStringArray(R.array.club_description)

        items.clear()

        for(i in name.indices){

            items.add(Item(name[i], image.getResourceId(i, 0), description[i]))
        }

        image.recycle()
    }
}
