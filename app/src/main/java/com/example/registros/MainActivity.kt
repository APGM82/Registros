package com.example.registros

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.registros.Modelo.Almacen
import com.example.registros.Modelo.Persona
import com.example.registros.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            // Get data from Intent
            val objeto: Persona = data!!.getSerializableExtra("objPersona") as Persona
            Almacen.addpersona(objeto)

        } else { }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnRegistrar.setOnClickListener {

                val intent = Intent(this, Formulario::class.java)
                resultLauncher.launch(intent)

        }

        binding.btnListar.setOnClickListener {
            var intentRegistro = Intent(this, Lista::class.java)
            startActivity(intentRegistro)
        }
        binding.btnModificar.setOnClickListener {

            val intent = Intent(this, Modificar::class.java)
            resultLauncher.launch(intent)

        }

    }
}
