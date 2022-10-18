package com.example.registros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registros.databinding.ActivityFormularioBinding


class Formulario : AppCompatActivity() {
    lateinit var binding: ActivityFormularioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnFormVolver.setOnClickListener{
            finish()
        }
    }



}