/*
 *  Name Module		: FootBall
 *  Name Class      : RecyclerViewAdapter
 *  Author          : Yogi Siswanto
 *  Email           : yogisiswanto.c2@gmail.com
 *  Date Created    : 28th October 2018
 *  Language        : Kotlin
 *  Description     : class for inserting string and image into RecycleView Layout
 */


package com.yogisiswanto.football

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.yogisiswanto.anko.*
import org.jetbrains.anko.AnkoContext

/*
*   @Name Class :   RecyclerViewAdapter
*   @Params1    :   Context
*   @Param2     :   List from class Item
*   @Param3     :   Listener (Using Unit)
*/
class RecyclerViewAdapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){


    //creating function ViewHolder
//    override fun onCreateViewHolder(parent: ViewGroup, viewTyoe: Int) = ViewHolder(LayoutInflater.from(context).inflate(R.id.linear), parent, false))
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ClubUI().createView(AnkoContext.create(parent.context, parent)))
    }

    //function for binding data position and listener
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItem(items[position], listener)
    }

    //function for counting items size
    override fun getItemCount(): Int = items.size

    //function for binding data string, image for RecycleView and listener
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val name = view.findViewById<TextView>(R.id.name)
        private val image = view.findViewById<ImageView>(R.id.gambar)

        fun bindItem(items: Item, listener: (Item) -> Unit){


            name.text = items.name
            items.image?.let { Picasso.get().load(it).into(image) }
            itemView.setOnClickListener{
                listener(items)
            }
//            println(items.name)
        }
    }
}