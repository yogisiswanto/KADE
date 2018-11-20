/*
 *  Name Class      : SecondActivity
 *  Author          : Yogi Siswanto
 *  Email           : yogisiswanto.c2@gmail.com
 *  Language        : Kotlin
 *  Description     : This class is Second Activity
 */

package com.yogisiswanto.anko.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.yogisiswanto.anko.R
import org.jetbrains.anko.setContentView

class SecondActivity : AppCompatActivity() {

    //variable
    private var footBallCLubName: String = ""
    private var footBallClubPicture: Int = 0
    private var footBallCLubDescription: String = ""

    //component
    private lateinit var clubName: TextView
    private lateinit var clubPicture: ImageView
    private lateinit var clubDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //calling MainActivityUI
        DescriptionUI().setContentView(this)

        //get intent
        val intent = intent

        footBallCLubName = intent.getStringExtra("footBallClubName")
        footBallClubPicture = intent.getIntExtra("footBallClubPicture", R.drawable.barcelona)
        footBallCLubDescription = intent.getStringExtra("footBallClubDescription")

        //component initialization
        clubName = findViewById<TextView>(R.id.clubName)
        clubPicture = findViewById<ImageView>(R.id.clubPicture)
        clubDescription = findViewById<TextView>(R.id.clubDescription)

        //inserting name, picture and description
        Picasso.get().load(footBallClubPicture).into(clubPicture)
        clubName.text = footBallCLubName
        clubDescription.text = footBallCLubDescription


    }
}
