package fr.isen.fazzino.androiderestaurant.data

import java.io.Serializable


data class Category(

    val name_fr:String,
    val name_en:String,
    val items : List<Dish>,
) : Serializable

