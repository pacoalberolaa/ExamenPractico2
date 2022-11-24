package com.example.examenpractico2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class VerTotalActivity : AppCompatActivity() {
    companion object{
        val EXTRA_BRUTO = "2ExamenPractico.CompraActivity.etPrecio"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_total)
    }
}