package com.example.examenpractico2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CompraActivity : AppCompatActivity() {



    private lateinit var etPrecio: EditText
    private lateinit var etCantidad: EditText
    private lateinit var btVerTotal: Button
    private var resul:Int = 0


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compra)

        etPrecio= findViewById(R.id.etPrecio)
        etCantidad = findViewById(R.id.etCantidad)
        btVerTotal = findViewById(R.id.btVerTotal)

        val num1:Int = Integer.parseInt(etCantidad.text.toString())
        val num2:Int = Integer.parseInt(etPrecio.text.toString())
        resul = num1 * num2

        println(resul)

        btVerTotal.setOnClickListener{enviarVerTotal()}



    }

    fun enviarVerTotal() {
        val intent = Intent(this, VerTotalActivity::class.java)
        intent.putExtra(VerTotalActivity.EXTRA_BRUTO, resul)
        startActivity(intent)
    }
}