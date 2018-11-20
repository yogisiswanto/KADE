/*
 *  Name Class      : MainActivityUI
 *  Author          : Yogi Siswanto
 *  Email           : yogisiswanto.c2@gmail.com
 *  Language        : Kotlin
 *  Description     : This class is UI for main activity using Anko
 */

package com.yogisiswanto.anko.view

import com.yogisiswanto.anko.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

//this class is extended from AnkoComponent
class MainActivityUI : AnkoComponent<MainActivity> {

    //function for createView using constraintLayout and recyclerView
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        //constraintLayout
        constraintLayout {

            //setting width and height for constraintLayout same with parrent width and height
            lparams(matchParent, matchParent)

            //recyclerView
            recyclerView {

                //id for recyclerView
                id = R.id.clubList

                //setting width and height for recyclerView same with parrent width and height
                lparams(matchParent, matchParent)

            }

        }
    }
}