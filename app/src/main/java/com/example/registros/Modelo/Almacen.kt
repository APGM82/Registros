package com.example.registros.Modelo

object Almacen {
    var listaPersonas = ArrayList<Persona>()
    fun addpersona(pe:Persona){
        listaPersonas.add(pe)
    }
}