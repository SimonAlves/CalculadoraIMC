package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btncalculate: Button = findViewById(R.id.btncalculate)
        val edtPeso: EditText = findViewById(R.id.edittext_peso)
        val edtAltura: EditText = findViewById(R.id.edittext_altura)


        btncalculate.setOnClickListener {
            val alturaString = edtAltura.text.toString()
            val pesoString = edtAltura.text.toString()
            if (alturaString.isNotEmpty() && pesoString.isNotEmpty()) {

                val altura: Float = alturaString.toFloat()
                val peso: Float = edtPeso.text.toString().toFloat()
                val alturaFinal: Float = altura * altura
                val result: Float = peso / alturaFinal


                val Intent = Intent(this, ResultActivity::class.java)
                    .apply {

                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(Intent)
            } else {
                Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}