package com.example.examenpractico2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class VerTotalActivity : AppCompatActivity() {
    companion object{
        val EXTRA_BRUTO = "ExamenPractico2.CompraActivity.etPrecio"
    }
    private lateinit var tvValorBruto: TextView
    private lateinit var tvValorNeto: TextView
    private lateinit var tvValorIVA: TextView
    private lateinit var btFacturar: Button
    private var resul:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_total)

        tvValorBruto = findViewById(R.id.tvValorBruto)
        tvValorIVA = findViewById(R.id.tvValorIVA)
        tvValorNeto = findViewById(R.id.tvValorNeto)
        btFacturar = findViewById(R.id.btFacturar)

        val bruto = intent.getStringExtra(EXTRA_BRUTO)

        tvValorBruto.text = bruto

        val num1 = bruto.toString().toDouble()
        resul = (16 * num1 / 100) + num1

        tvValorNeto.text = resul.toString()

        btFacturar.setOnClickListener{verFactura()}


    }

    fun verFactura(){
        val intent = Intent()
        intent.putExtra("Neto", tvValorNeto.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }
}