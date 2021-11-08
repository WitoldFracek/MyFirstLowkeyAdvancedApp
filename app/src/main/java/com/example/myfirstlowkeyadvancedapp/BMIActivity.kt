package com.example.myfirstlowkeyadvancedapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class BMIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmiactivity)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val receivedBundle = intent.extras
        val height: Double? = receivedBundle?.getDouble("height", 1.0)
        val weight: Double? = receivedBundle?.getDouble("weight", 1.0)

        val weightText: TextView = findViewById(R.id.edit_weight_bmi)
        weightText.isEnabled = false
        weightText.text = weight.toString()

        val heightText: TextView = findViewById(R.id.edit_height_bmi)
        heightText.isEnabled = false
        heightText.text = height.toString()

        val resultField: TextView = findViewById(R.id.textView_bmi_result)

        val buttonCalculate: Button = findViewById(R.id.calculate_bmi_button)
        buttonCalculate.setOnClickListener { _ ->
            val res: Double? = height?.let { weight?.div(it*it) }
            //val res = weight?.div(heightSquared!!.toDouble())
//            fun Double.round(decimals: Int = 2):Double = "%.${decimals}f".format(this).toDouble()
//            var temp = 0.0
//            if (res != null) {
//                temp = res.round()
//            }
            resultField.text = res.toString()
            intent.putExtra("bmi", res)
            setResult(RESULT_OK, intent)

            finish()
        }

        val backButton: Button = findViewById(R.id.bmi_button_back)
        backButton.setOnClickListener { _ ->
            //val res = String.format("%2f" ,resultField.text.toString().toDouble()).toDouble()
            val res = if(resultField.text.isNotBlank()) {
                resultField.text.toString().toDouble()
            } else {
                1.0
            }
            intent.putExtra("bmi", res)
            Toast.makeText(this, res.toString(), Toast.LENGTH_LONG).show()
            setResult(RESULT_OK, intent)

            onBackPressed()
        }
    }

}