package com.example.registros

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registros.Modelo.Persona
import com.example.registros.databinding.ActivityFormularioBinding


class Formulario : AppCompatActivity() {
    lateinit var binding: ActivityFormularioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFormGuardar.setOnClickListener{
            if(binding.txtNombre.text.toString()!=""&&binding.txtEdad.text.toString()!=""&&binding.txtEstudios.text.toString()!=""){

               var p: Persona=(Persona(binding.txtNombre.text.toString(),binding.txtEdad.text.toString(),binding.txtEstudios.text.toString()))

                val intent = Intent()
                intent.putExtra("objPersona", p)
                setResult(Activity.RESULT_OK, intent)
                finish()

            }else{Toast.makeText(this,"Rellene todos los campos",Toast.LENGTH_LONG).show()}
        }

        binding.btnFormVolver.setOnClickListener{

            val intent = Intent()
            setResult(Activity.RESULT_CANCELED, intent)
            finish()
        }
    }
}



