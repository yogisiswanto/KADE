/*
 *  Name Class      : ClubUI
 *  Author          : Yogi Siswanto
 *  Email           : yogisiswanto.c2@gmail.com
 *  Language        : Kotlin
 *  Description     : This class is UI for viewing FootBall Club using Anko
 */

package com.yogisiswanto.anko.view

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.yogisiswanto.anko.R
import org.jetbrains.anko.*

//this class is extended from AnkoComponent
class ClubUI : AnkoComponent<ViewGroup> {

    //function for createView using linearLayout
    override fun createView(ui: AnkoContext<ViewGroup>): View {

        return with(ui) {

            linearLayout {

                //                id for linear layout
                id = R.id.linear

                //setting width and height for linearLayout
                lparams(matchParent, wrapContent)

                //setting padding
                setPadding(dip(16), dip(16), dip(16), dip(16))

                //set orientation
                orientation = LinearLayout.HORIZONTAL

                //imageView
                imageView {

                    //id for imageView
                    id = R.id.picture

                    //set defaul image resource
                    setImageResource(R.drawable.barcelona)
                }
                    //set width and height for imageView
                    .lparams(width = dip(50), height = dip(50))

                //textView
                textView {

                    //id for textView
                    id = R.id.name

                    //set default text
                    text = "Barcelona"
                }
                    //set width, height, margin and text alignment for textView
                    .lparams {
                        width = wrapContent
                        height = wrapContent
                        margin = dip(10)
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }


            }
        }
    }

}