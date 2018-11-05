package com.yogisiswanto.anko

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.yogisiswanto.football.RecyclerViewAdapter
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    //calling Item class
    private var items : MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)

        //calling RecycleView Layout
        val list = findViewById<RecyclerView>(R.id.clubList)

        //calling initData Function
        initData()

        //calling linear layout
        list.layoutManager = LinearLayoutManager(this)

        //calling RecycleView Adapter
        //input context and Items class
        //showing Toast when clicked
        list.adapter = RecyclerViewAdapter(this, items){
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    /*
    *   @Name Method    : initData
    *   @Description    : Calling string name, and string image from drawable to class Item
    */
    private fun initData(){

        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)

        items.clear()

        for(i in name.indices){

            items.add(Item(name[i], image.getResourceId(i, 0)))
        }

        image.recycle()
    }
}
