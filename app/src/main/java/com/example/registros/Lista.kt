package com.example.registros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registros.Modelo.Almacen
import com.example.registros.Modelo.Almacen.listaPersonas
import com.example.registros.Modelo.Persona
import com.example.registros.databinding.ActivityListaBinding

import Adaptadores.MiAdaptadorRecycler


class Lista : AppCompatActivity() {
    lateinit var binding: ActivityListaBinding
    lateinit var miRecyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        miRecyclerView = binding.listaPersonasRecycler as RecyclerView
        miRecyclerView.setHasFixedSize(true)
        miRecyclerView.layoutManager = LinearLayoutManager(this)
        var miAdapter = MiAdaptadorRecycler(listaPersonas, this)
        miRecyclerView.adapter = miAdapter


        val adaptador= ArrayAdapter(this,R.layout.item_lista,R.id.textView,Almacen.listaPersonas)
        binding.spLista.adapter=adaptador

        binding.btnVolverLista.setOnClickListener{
            finish()
        }

    }
}