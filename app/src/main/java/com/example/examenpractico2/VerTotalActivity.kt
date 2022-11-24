package com.example.examenpractico2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class VerTotalActivity : AppCompatActivity() {
    companion object{
        val EXTRA_BRUTO = "ExamenPractico2.CompraActivity.etPrecio"
    }
    private lateinit var tvValorBruto: TextView
    private lateinit var tvValorNeto: TextView
    private lateinit var tvValorIVA: TextView
    private var resul:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_total)

        tvValorBruto = findViewById(R.id.tvValorBruto)
        tvValorIVA = findViewById(R.id.tvValorIVA)
        tvValorNeto = findViewById(R.id.tvValorNeto)

        val bruto = intent.getStringExtra(EXTRA_BRUTO)

        tvValorBruto.text = bruto

        val num1 = bruto.toString().toInt()
        resul = ((16 * (num1) / 100) + num1).toDouble()

        tvValorNeto.text = resul.toString()


    }
}