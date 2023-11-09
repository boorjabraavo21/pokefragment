package com.turing.alan.fragmentspokemon.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(val id:Int,
                   val name: String,
    val description: String,
    val mainType:String,
    val secondaryType:String?,
    val imageId:Int):Parcelable
