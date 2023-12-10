package com.example.repasolibrosdrawer.fragments

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebarepasofragment.Adapter.LibroAdapter
import com.example.repasolibrosdrawer.OnInteractionListener
import com.example.repasolibrosdrawer.R
import com.example.repasolibrosdrawer.databinding.FragmentVerLibroBinding
import com.example.repasolibrosdrawer.modelo.entidades.LibroViewmodel

class verLibro_Fragment : Fragment() {

    private var binding: FragmentVerLibroBinding? = null
    private val viewModel: LibroViewmodel by activityViewModels()

    lateinit var miAdapter: LibroAdapter

    lateinit var listener: OnInteractionListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVerLibroBinding.inflate(inflater, container, false)
        val root: View = binding!!.root

        initRecyclerView()

        return root
    }



    fun initRecyclerView() {
        val recyclerView = binding!!.recyclerLibro
        recyclerView.layoutManager = LinearLayoutManager(context)
        miAdapter = LibroAdapter(viewModel.listaLibros,onClickDelete = {position -> onClickDelete(position)})
        viewModel.recyclerViewAdapter = miAdapter
        recyclerView.adapter = miAdapter




    }

    private fun onClickDelete(position: Int) {
        viewModel.listaLibros.removeAt(position)
        miAdapter.notifyItemRemoved(position)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

}