package com.delafuente.figurasapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "figuras")
data class Figura(
    @PrimaryKey val id: Int,
    val nombre: String,
    val logo: String,
    val fecha: String?,
    val origen: String?,
    val pelicula: String?,
    val descripcion: String?,
    val colores: List<String>?,
    val disponibilidad: Boolean?,
    val precio: Double?
)
