package com.vijoin.aprendiendokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

data class Cursos(val nombre: String, val url: String)

class MainActivity : AppCompatActivity() {

    val react = Cursos(nombre = "React", url = "react")
    val kot = Cursos(nombre = "Kotlin", url = "kotlin")
    var cursoActual = react.copy()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.botoncito)
        boton.setOnClickListener {
                switchCurso(cursoActual)
        }

    }
        fun switchCurso(curso:Cursos) {

            cursoActual = curso.copy()
            when(cursoActual.url)
            {
                "react" -> cursoActual = kot.copy()
                "kotlin" -> cursoActual = react.copy()
            }

            verEnPantalla("Curso de ${cursoActual.nombre} en platzi.com/${cursoActual.url}")

        }


        fun verEnPantalla(s: String){
            val txt = findViewById<TextView>(R.id.mensaje)
            txt.setText(s)
        }






}
