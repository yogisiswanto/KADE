package com.yogisiswanto.anko

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class ClubUI() : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {

        return with(ui){
            linearLayout {
                id = R.id.linear
                lparams(matchParent, matchParent)
                orientation = LinearLayout.HORIZONTAL

                imageView {

                    id = R.id.gambar
//                    setImageResource(R.drawable.barcelona)
                }
                    .lparams(width = dip(50), height = dip(50))

                textView {

                    id = R.id.name
//                    text = "Barcelona"
                }
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