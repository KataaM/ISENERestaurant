package fr.isen.fazzino.androiderestaurant.data

import kotlinx.serialization.Serializable

@Serializable
data class DataDish(
    val data : List<Category>,
    )

