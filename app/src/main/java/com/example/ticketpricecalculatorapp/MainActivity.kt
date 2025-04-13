package com.example.ticketpricecalculatorapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etAdult: EditText
    private lateinit var etChild: EditText
    private lateinit var cbAudio: CheckBox
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    private val ADULT_PRICE = 200
    private val CHILD_PRICE = 100
    private val AUDIO_GUIDE_PRICE = 50


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etAdult = findViewById(R.id.etAdultTickets)
        etChild = findViewById(R.id.etChildTickets)
        cbAudio = findViewById(R.id.cbAudioGuide)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvResult = findViewById(R.id.tvResult)

        btnCalculate.setOnClickListener {
            calculateTotal()
        }
    }

    private fun calculateTotal() {
        val adultTickets = etAdult.text.toString().toIntOrNull() ?: 0
        val childTickets = etChild.text.toString().toIntOrNull() ?: 0
        val audioSelected = cbAudio.isChecked

        var total = (adultTickets * ADULT_PRICE) + (childTickets * CHILD_PRICE)
        if (audioSelected) total += AUDIO_GUIDE_PRICE

        tvResult.text = "Total: ₹$total"
    }
}