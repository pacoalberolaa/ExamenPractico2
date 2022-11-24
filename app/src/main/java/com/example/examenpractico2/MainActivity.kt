package com.example.examenpractico2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btCompra: Button
    private lateinit var btDetalles : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btCompra = findViewById(R.id.btCompra)
        btDetalles = findViewById(R.id.btDetalles)

        btCompra.setOnClickListener { enviarCompra() }
        btDetalles.setOnClickListener{enviarDetalles()}
    }


    fun enviarCompra(){
        val intent = Intent(this, CompraActivity::class.java)
        startActivity(intent)
    }

    fun enviarDetalles(){
        val intent = Intent(this, DetallesActivity::class.java)
        startActivity(intent)
    }


}