package fr.isen.fazzino.androiderestaurant.data

data class Price(
    val id: Int,
    val id_pizza:Int,
    val id_size:Int,
    val price:Int,
    val create_date:String,
    val update_date:String,
    var size :  String
)
