package com.example.examenpractico2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class CompraActivity : AppCompatActivity() {

    private lateinit var etPrecio: EditText
    private lateinit var etCantidad: EditText
    private lateinit var btVerTotal: Button
    private lateinit var tvTotal : TextView

    private val verTotalLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ activityResult ->
        if (activityResult.resultCode == RESULT_OK){
            val neto = activityResult.data?.getStringExtra("Neto").orEmpty()
            tvTotal.text = String.format(getString(R.string.total), neto)
            tvTotal.visibility = View.VISIBLE

        }
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compra)

        etPrecio= findViewById(R.id.etPrecio)
        etCantidad = findViewById(R.id.etCantidad)
        btVerTotal = findViewById(R.id.btVerTotal)
        tvTotal = findViewById(R.id.tvTotal)


        tvTotal.visibility = View.GONE
        btVerTotal.setOnClickListener{enviarVerTotal()}

    }

    fun enviarVerTotal() {
        val num1:Int = etCantidad.text.toString().toInt()
        val num2:Int = etPrecio.text.toString().toInt()
        val resul = num1 * num2

        val intent = Intent(this, VerTotalActivity::class.java)
        intent.putExtra(VerTotalActivity.EXTRA_BRUTO, resul.toString())
        verTotalLauncher.launch(intent)
    }
}