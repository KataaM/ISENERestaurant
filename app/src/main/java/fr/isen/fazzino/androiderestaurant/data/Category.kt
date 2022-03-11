package fr.isen.fazzino.androiderestaurant.data

data class Category(

    val name_fr:String,
    val name_en:String,
    val items : List<Dish>,
)

