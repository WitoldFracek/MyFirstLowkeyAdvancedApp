package com.example.myfirstlowkeyadvancedapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.view.Gravity
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val startForResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            Toast.makeText(this, "I'm in", Toast.LENGTH_LONG).show()
            when(result.resultCode) {
                RESULT_OK -> {
                    val gotIntent = result.data
                    val bmi = gotIntent?.getDoubleExtra("bmi", 1.0)
                    if (bmi != null) {
                        val temp = bmi.toString()
                        findViewById<TextView>(R.id.textView_bmi).text = temp
                    }
                }
            }
        }

        val edWeightArea: EditText = findViewById(R.id.edit_weight_area)
        val BMIButton: Button = findViewById(R.id.bmi_button)
        BMIButton.setOnClickListener { _ ->
            val weight = if(edWeightArea.text.isNotBlank()) {
                edWeightArea.text.toString().toDouble()
            } else {
                1.0
            }

            val edHeightArea: EditText = findViewById(R.id.edit_height_area)

            val height = if (edHeightArea.text.isNotBlank()) {
                edHeightArea.text.toString().toDouble()
            } else {
                1.0
            }

            //Toast.makeText(this, "$weight, $height", Toast.LENGTH_LONG).show()
            val bundle = Bundle()
            bundle.putDouble("height", height)
            bundle.putDouble("weight", weight)

            val myIntent = Intent(this, BMIActivity::class.java)
            myIntent.putExtras(bundle)
            startForResult.launch(myIntent)
        }
    }

//    fun toastAct2(v: View) {
//        val text = findViewById<TextView>(R.id.edit_text_area).getText().toString()
//        val mail = findViewById<TextView>(R.id.edit_mail_area).getText().toString()
//        val number = findViewById<TextView>(R.id.edit_nuber_area).getText().toString()
//        val phone = findViewById<TextView>(R.id.edit_phone_area).getText().toString()
//        val message: String = "Tekst: $text\nE-mail: $mail\nLiczba: $number\nTel.: $phone"
//
//        val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
//        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0)
//        toast.show()
//    }

    fun backAct2(v: View) {
        finish()
        val myIntent = Intent(this, MainActivity::class.java)
        startActivity(myIntent)
    }
}