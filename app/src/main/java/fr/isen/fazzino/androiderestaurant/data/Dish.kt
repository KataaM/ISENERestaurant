package fr.isen.fazzino.androiderestaurant.data

import java.io.Serializable


data class Dish(

    val id: Int,
    val name_fr:String,
    val name_en:String,
    val id_category: Int,
    val categ_name_fr:String,
    val categ_name_en:String,
    var images : List<String>,
    var ingredients : List<Ingredients>,
    var prices :  List<Price>,
): Serializable
