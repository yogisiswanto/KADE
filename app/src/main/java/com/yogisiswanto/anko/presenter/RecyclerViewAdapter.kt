/*
 *  Name Class      : RecyclerViewAdapter
 *  Author          : Yogi Siswanto
 *  Email           : yogisiswanto.c2@gmail.com
 *  Language        : Kotlin
 *  Description     : This class for inserting string and image into RecycleView Layout
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
import com.yogisiswanto.anko.view.ClubUI
import org.jetbrains.anko.AnkoContext
import kotlinx.android.extensions.LayoutContainer

/*
*   @Name Class :   RecyclerViewAdapter
*   @Params1    :   Context
*   @Param2     :   List from class Item
*   @Param3     :   Listener (Using Unit)
*/
class RecyclerViewAdapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    //creating function ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ClubUI().createView(AnkoContext.create(context, parent)))
    }


    //function for binding data position and listener
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItem(items[position], listener)
    }

    //function for counting items size
    override fun getItemCount(): Int = items.size


    //class for binding data string, image, and listener
    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        //component initialization
        private val name = itemView.findViewById<TextView>(R.id.name)
        private val image = itemView.findViewById<ImageView>(R.id.picture)

        fun bindItem(items: Item, listener: (Item) -> Unit){

            name.text = items.name
            items.image.let { Picasso.get().load(it).into(image) }
            itemView.setOnClickListener{
                listener(items)
            }
        }
    }
}
