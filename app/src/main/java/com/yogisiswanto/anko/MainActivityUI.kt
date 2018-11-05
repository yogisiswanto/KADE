package com.yogisiswanto.anko


import org.jetbrains.anko.*

import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivityUI : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        constraintLayout{

            lparams(matchParent, matchParent)

            recyclerView{

                id = R.id.clubList
                lparams(matchParent, matchParent)

            }

        }
    }
}