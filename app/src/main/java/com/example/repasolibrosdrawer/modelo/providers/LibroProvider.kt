package com.example.pruebarepasofragment.modelo.providers

import com.example.pruebarepasofragment.modelo.entidades.Libro

class LibroProvider {
    companion object {
        val libros =  listOf<Libro>(
            Libro("Pinocho",100,"Pablo"),
            Libro("Don Quijote de la Mancha", 200, "Miguel de Cervantes"),
            Libro("Cien años de soledad", 150, "Gabriel García Márquez"),
            Libro("El principito", 120, "Antoine de Saint-Exupéry"),
            Libro("Moby Dick", 180, "Herman Melville"),
            Libro("Orgullo y prejuicio", 220, "Jane Austen"),
            Libro("El señor de los anillos", 300, "J.R.R. Tolkien"),
            Libro("Crónica de una muerte anunciada", 110, "Gabriel García Márquez"),
            Libro("El perfume", 160, "Patrick Süskind"),
            Libro("1984", 170, "George Orwell")
        )
    }
}