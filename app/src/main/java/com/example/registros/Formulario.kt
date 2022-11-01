package com.example.registros

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registros.Modelo.Persona
import com.example.registros.databinding.ActivityFormularioBinding


class Formulario : AppCompatActivity() {
    private val cameraRequest = 1888
    lateinit var binding: ActivityFormularioBinding
    lateinit var miRecyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), cameraRequest)


        binding.btnTomarFoto.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, cameraRequest)
        }

        binding.btnFormGuardar.setOnClickListener{
            if(binding.txtNombre.text.toString()!=""&&binding.txtDni.text.toString()!=""&&binding.txtTelefono.text.toString()!=""){

               var p: Persona=(Persona(binding.txtNombre.text.toString(),binding.txtDni.text.toString(),binding.txtTelefono.text.toString(),binding.imgFoto.toString()))

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
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == cameraRequest) {
            val photo: Bitmap = data?.extras?.get("data") as Bitmap
            binding.imgFoto.setImageBitmap(photo)
        }
    }

}



