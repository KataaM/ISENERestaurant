package fr.isen.fazzino.androiderestaurant.data

import kotlinx.serialization.Serializable

@Serializable
data class Price(
    val id: Int,
    val id_pizza:Int,
    val id_size:Int,
    val price:Float,
    val create_date:String,
    val update_date:String,
    var size :  String
)
