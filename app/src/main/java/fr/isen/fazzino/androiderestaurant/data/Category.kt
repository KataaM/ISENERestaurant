package fr.isen.fazzino.androiderestaurant.data

import kotlinx.serialization.Serializable

@Serializable
data class Category(

    val name_fr:String,
    val name_en:String,
    val items : List<Dish>,
)

