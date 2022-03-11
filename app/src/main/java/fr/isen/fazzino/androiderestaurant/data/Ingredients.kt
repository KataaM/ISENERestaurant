package fr.isen.fazzino.androiderestaurant.data

import kotlinx.serialization.Serializable

@Serializable
data class Ingredients(
    val id: Int,
    val id_shop:Int,
    val name_fr:String,
    val name_en:String,
    val create_date:String,
    val update_date:String,
    var id_pizza :  Int,
)
