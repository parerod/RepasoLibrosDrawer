package com.example.pruebarepasofragment.Adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pruebarepasofragment.modelo.entidades.Libro
import com.example.repasolibrosdrawer.R
import com.example.repasolibrosdrawer.databinding.ItemLibroBinding

class LibroViewHolder(view : View) : ViewHolder(view) {

    val binding = ItemLibroBinding.bind(view)

    var titulo = view.findViewById<TextView>(R.id.titulo)
    var paginas = view.findViewById<TextView>(R.id.paginas)
    var autor = view.findViewById<TextView>(R.id.autor)

    fun render(libro : Libro,onClickDelete: (Int) ->Unit) {
        titulo.text = libro.titulo
        paginas.text = libro.paginas.toString()
        autor.text = libro.autor

        binding.btnBorrar.setOnClickListener{onClickDelete(adapterPosition)}
    }



}