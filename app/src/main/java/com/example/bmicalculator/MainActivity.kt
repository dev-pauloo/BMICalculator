package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate : Button = findViewById(R.id.btnCalculate)
        val edtHt : EditText = findViewById(R.id.height)
        val edtWt : EditText = findViewById(R.id.weight)

        btnCalculate.setOnClickListener {
            val heightStr = edtHt.text.toString()
            val weightStr = edtWt.text.toString()

            if (heightStr.isNotEmpty() && weightStr.isNotEmpty()) {
                val finalHeight: Float = edtHt.text.toString().toFloat()
                val finalWeight: Float = edtWt.text.toString().toFloat()
                val result: Float = finalWeight / (finalHeight * finalHeight)


                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("EXTRA_RESULT", result)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_LONG).show()
            }
        }
    }
}