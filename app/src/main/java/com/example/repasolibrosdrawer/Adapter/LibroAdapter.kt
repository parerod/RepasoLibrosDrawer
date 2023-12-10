package com.example.pruebarepasofragment.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebarepasofragment.modelo.entidades.Libro
import com.example.repasolibrosdrawer.R

class LibroAdapter (private val libroList : List<Libro>, private val onClickDelete:(Int)->Unit) : RecyclerView.Adapter<LibroViewHolder>() {

    override fun getItemCount(): Int = libroList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return LibroViewHolder(layoutInflater.inflate(R.layout.item_libro,parent,false))
    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val item = libroList[position]
        holder.render(item,onClickDelete)
    }





}