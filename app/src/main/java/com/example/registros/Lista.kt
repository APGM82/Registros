package com.example.registros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.registros.Modelo.Almacen
import com.example.registros.Modelo.Persona
import com.example.registros.databinding.ActivityListaBinding


class Lista : AppCompatActivity() {
    lateinit var binding: ActivityListaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val adaptador= ArrayAdapter(this,R.layout.item_lista,R.id.textView,Almacen.listaPersonas)
        binding.spLista.adapter=adaptador

        binding.btnVolverLista.setOnClickListener{
            finish()
        }
    }
}