/*
 *  Name Class      : DescriptionUI
 *  Author          : Yogi Siswanto
 *  Email           : yogisiswanto.c2@gmail.com
 *  Language        : Kotlin
 *  Description     : This class is UI for viewing FootBall Club name, picture and description using Anko
 */

package com.yogisiswanto.anko.view

import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.yogisiswanto.anko.R
import org.jetbrains.anko.*

//this class is extended from AnkoComponent
class DescriptionUI : AnkoComponent<SecondActivity> {

    //function for createView using linearLayout
    override fun createView(ui: AnkoContext<SecondActivity>) = with(ui) {

        linearLayout {

            //id for linear layout
            id = R.id.linear

            //setting width and height for linearLayout
            lparams(matchParent, wrapContent)

            //setting padding
            setPadding(dip(16), dip(16), dip(16), dip(16))

            //set orientation
            orientation = LinearLayout.VERTICAL

            //imageView
            imageView {

                //id for imageView
                id = R.id.clubPicture

                //set defaul image resource
                setImageResource(R.drawable.barcelona)
            }
                //set width, height, margin and gravity for imageView
                .lparams {
                    width = dip(100)
                    height = dip(100)
                    margin = dip(10)
                    gravity = Gravity.CENTER
                }

            //textView for name FootBall club
            textView {

                //id for textView
                id = R.id.clubName

//                //set default text
//                text = "Barcelona"
            }
                //set width, height, margin, text alignment and gravity for textView
                .lparams {
                    width = wrapContent
                    height = wrapContent
                    margin = dip(10)
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    gravity = Gravity.CENTER
                }

            //textView for description FootBall club
            textView {

                //id for textView
                id = R.id.clubDescription

                //set default text
//                text = "asdasd"
            }
                //set width, height, margin, text alignment and gravity for textView
                .lparams {
                    width = wrapContent
                    height = wrapContent
                    margin = dip(10)
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    gravity = Gravity.CENTER
                }


        }
    }
}

