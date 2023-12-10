package com.example.repasolibrosdrawer.modelo.entidades

import androidx.lifecycle.ViewModel
import com.example.pruebarepasofragment.Adapter.LibroAdapter
import com.example.pruebarepasofragment.modelo.entidades.Libro

class LibroViewmodel : ViewModel() {

    var listaLibros: MutableList<Libro> = mutableListOf()

    lateinit var recyclerViewAdapter : LibroAdapter



    fun addLibro(libri: Libro) {
        listaLibros.add(libri)
    }

    fun verLibro(nombre: String): Libro? {
        var libri: Libro? = listaLibros.find { it.titulo == nombre }
        return libri
    }

    fun verLibros(): MutableList<Libro> {
        return listaLibros
    }
}