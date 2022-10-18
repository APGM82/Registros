package com.example.registros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registros.databinding.ActivityListaBinding
import com.example.registros.databinding.ActivityMainBinding


class Lista : AppCompatActivity() {
    lateinit var binding: ActivityListaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVolverLista.setOnClickListener{
            finish()
        }
    }
}