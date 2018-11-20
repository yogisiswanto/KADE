/*
 *  Name Class      : Items
 *  Author          : Yogi Siswanto
 *  Email           : yogisiswanto.c2@gmail.com
 *  Language        : Kotlin
 *  Description     : Making data class which contain name, image and description
 */

package com.yogisiswanto.anko

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(val name: String, val image: Int, val description: String) : Parcelable