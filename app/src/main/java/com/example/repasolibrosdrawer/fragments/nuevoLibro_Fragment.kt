package com.example.repasolibrosdrawer.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import com.example.pruebarepasofragment.modelo.entidades.Libro
import com.example.repasolibrosdrawer.R
import com.example.repasolibrosdrawer.databinding.DialogBinding
import com.example.repasolibrosdrawer.databinding.FragmentNuevoLibroBinding
import com.example.repasolibrosdrawer.modelo.entidades.LibroViewmodel

class nuevoLibro_Fragment : Fragment() {

    private var binding: FragmentNuevoLibroBinding? = null
    private val viewModel: LibroViewmodel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNuevoLibroBinding.inflate(inflater, container, false)
        val root: View = binding!!.root



        binding!!.anadirLibro.setOnClickListener {
            verDialogoNuevo()
        }

        


        return root
    }

    fun anadirLibro() {
        var titulo = binding!!.tituloLibro.text.toString()
        var autor = binding!!.autorLibro.text.toString()
        var paginas = binding!!.nPaginas.text.toString()
        if (titulo.isBlank()) {
            toast("El libro a guardar no es válido ... Revise")
        } else {
            viewModel.listaLibros.add(Libro(titulo,paginas.toInt(),autor))
            viewModel.recyclerViewAdapter.notifyDataSetChanged()
            viewModel.listaLibros.forEach {
                Log.d("pruebaLista",it.titulo)
            }
        }
        clearCajas()
    }

    private fun verDialogoNuevo() {

        val inflater = getLayoutInflater()

        var bindingo : DialogBinding = DialogBinding.inflate(inflater)
        val view=bindingo.root
        bindingo.tituloLibri.text = binding!!.tituloLibro.text
        val builder = AlertDialog.Builder(this.requireContext())

            .setView(view)
            .setTitle("Anadir usuario")
            .setPositiveButton("Anadir") { dialog, id ->
                run {
                    when (bindingo.radioAnadir.checkedRadioButtonId) {
                        R.id.radioSi -> {
                            anadirLibro()
                        }
                        else -> {
                        }
                    }
                }
            }
            .setNegativeButton("Cancelar") { dialog, id -> }
            .show()

    }

    fun clearCajas() {
        binding!!.tituloLibro.text.clear()
        binding!!.autorLibro.text.clear()
        binding!!.nPaginas.text.clear()
    }

    //Automatizar diferentes toast con un solo método
    fun toast(mensaje: String) {
        Toast.makeText(requireActivity(), mensaje, Toast.LENGTH_SHORT).show()
    }

}