package Auxiliar

import Conexion.AdminSQLIteConexion

import android.content.ContentValues
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.registros.Modelo.Persona

object Conexion {
    var nombreBD = "administracion.db3"

    fun cambiarBD(nombreBD:String){
        this.nombreBD = nombreBD
    }

    fun addPersona(contexto: AppCompatActivity, p: Persona){
        val admin = AdminSQLIteConexion(contexto, nombreBD, null, 1)
        val bd = admin.writableDatabase
        val registro = ContentValues()
        registro.put("dni", p.dni)
        registro.put("nombre",p.nombre)
        registro.put("telefono", p.telefono)
        bd.insert("personas", null, registro)
        bd.close()
    }

    fun delPersona(contexto: AppCompatActivity, dni: String):Int{
        val admin = AdminSQLIteConexion(contexto, nombreBD, null, 1)
        val bd = admin.writableDatabase
        val cant = bd.delete("personas", "dni='${dni}'", null)
        bd.close()
        return cant
    }

    fun modPersona(contexto:AppCompatActivity, dni:String, p:Persona):Int {
        val admin = AdminSQLIteConexion(contexto, nombreBD, null, 1)
        val bd = admin.writableDatabase
        val registro = ContentValues()
        registro.put("nombre", p.nombre)
        registro.put("telefono", p.telefono)
        val cant = bd.update("personas", registro, "dni='${dni}'", null)
        bd.close()
        return cant
    }

    fun buscarPersona(contexto: AppCompatActivity, dni:String):Persona? {
        var p:Persona? = null
        val admin = AdminSQLIteConexion(contexto, nombreBD, null, 1)
        val bd = admin.writableDatabase
        val fila = bd.rawQuery(
            "select nombre,telefono from personas where dni='${dni}'",
            null
        )
        if (fila.moveToFirst()) {
            p = Persona(dni, fila.getString(0), fila.getString(1),null)
        }
        bd.close()
        return p
    }

    fun obtenerPersonas(contexto: AppCompatActivity):ArrayList<Persona>{
        var personas:ArrayList<Persona> = ArrayList(1)

        val admin = AdminSQLIteConexion(contexto, nombreBD, null, 1)
        val bd = admin.writableDatabase
        val fila = bd.rawQuery("select dni,nombre,telefono from personas", null)
        while (fila.moveToNext()) {
            var p:Persona = Persona(fila.getString(0),fila.getString(1),fila.getString(2),null)
            personas.add(p)
        }
        bd.close()
        return personas
    }

}