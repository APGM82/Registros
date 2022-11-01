package com.example.registros

import Auxiliar.Conexion
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.registros.Modelo.Persona
import com.example.registros.databinding.ActivityMainBinding
import com.example.registros.databinding.ActivityModificarBinding

class Modificar : AppCompatActivity() {
    lateinit var binding: ActivityModificarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModificarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener{
            if (binding.edDNI.text.toString().trim().isEmpty() || binding.edNombre.text.toString().trim().isEmpty()
                || binding.edTelefono.text.toString().trim().isEmpty()){
                Toast.makeText(this, "Campos en blanco", Toast.LENGTH_SHORT).show()
            }
            else {
                var pers: Persona = Persona(

                    binding.edDNI.getText().toString(),
                    binding.edNombre.getText().toString(),
                    binding.edTelefono.getText().toString(),
                    null
                )
                Conexion.addPersona(this, pers)
                binding.edDNI.setText("")
                binding.edNombre.setText("")
                binding.edTelefono.setText("")
                Toast.makeText(this, "Persona insertada", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnBorrar.setOnClickListener{
            var cant = Conexion.delPersona(this, binding.edDNI.text.toString())
            binding.edDNI.setText("")
            binding.edNombre.setText("")
            binding.edTelefono.setText("")
            if (cant == 1)
                Toast.makeText(this, "Se borró la persona con ese DNI", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe una persona con ese DNI", Toast.LENGTH_SHORT).show()
        }

        binding.btnEditar.setOnClickListener{
            if (binding.edDNI.text.toString().trim().isEmpty()|| binding.edNombre.text.toString().trim().isEmpty()
                || binding.edTelefono.text.toString().trim().isEmpty()){
                Toast.makeText(this, "Campos en blanco", Toast.LENGTH_SHORT).show()
            }
            else {
                var pers: Persona = Persona(
                    binding.edDNI.getText().toString(),
                    binding.edNombre.getText().toString(),
                    binding.edTelefono.getText().toString(),
                    null
                )
                var cant = Conexion.modPersona(this, binding.edDNI.text.toString(), pers)
                if (cant == 1)
                    Toast.makeText(this, "Se modificaron los datos", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "No existe una persona con ese DNI", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnBuscar.setOnClickListener{
            var p:Persona? = null
            p = Conexion.buscarPersona(this, binding.edDNI.text.toString())
            if (p!=null) {
                binding.edNombre.setText(p.nombre)
                binding.edTelefono.setText(p.telefono.toString())
            } else {
                Toast.makeText(this, "No existe una persona con ese DNI", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnListar2.setOnClickListener{
            var listado:ArrayList<Persona> = Conexion.obtenerPersonas(this)

            binding.txtListado2.text = ""

            if (listado.size==0) {
                Toast.makeText(this, "No existen datos en la tabla", Toast.LENGTH_SHORT).show()
            }
            else {
                for(p in listado){
                    var cadena = p.dni + ", " + p.nombre + ", " + p.telefono.toString() + "\r\n"
                    binding.txtListado2.append(cadena)
                }
            }
        }

    }
}