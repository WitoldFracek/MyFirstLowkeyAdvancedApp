package com.example.myfirstlowkeyadvancedapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.view.View
import android.content.Intent
import android.view.Gravity
import android.widget.Toast
import android.widget.ImageView
import android.widget.ToggleButton
import android.widget.RadioButton
import android.view.MenuItem
import android.widget.EditText

class Activity1 : Activity() {

    private var isShown = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        val tggl: ToggleButton = findViewById(R.id.toggle_button_act1)
        tggl.isChecked = true
        val img: ImageView = findViewById(R.id.image_act1_asaro)
        tggl.setOnCheckedChangeListener{ _, isChecked ->
            if (isChecked) {
                img.setVisibility(ImageView.VISIBLE)
            } else {
                img.setVisibility(ImageView.INVISIBLE)
            }
            isShown = isChecked
        }
        val radioButton: RadioButton = findViewById(R.id.radio_button_1)
        radioButton.isChecked = true


    }


    fun back(v: View) {
        finish()
        val myIntent = Intent(this, MainActivity::class.java)
        startActivity(myIntent)
    }

    fun toast(v: View) {
        val textEditor: EditText = findViewById(R.id.multiline_text_editor_act1)
        val text = textEditor.getText().toString()
        var message: String = ""
        message += if (isShown) {
            "The image is shown"
        } else {
            "The image is hidden"
        }
        message += " and the text is:\n"
        message += text

        val toast: Toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0)
        toast.show()
    }

    fun onRadioButtonClicked(v: View) {
        if (v is RadioButton) {
            val textArea: EditText = findViewById(R.id.multiline_text_editor_act1)
            val checked = v.isChecked
            when (v.getId()) {
                R.id.radio_button_1 -> {
                    if (checked) {
                        textArea.isEnabled = true
                        findViewById<RadioButton>(R.id.radio_button_2).isChecked = false
                    }
                }
                R.id.radio_button_2 -> {
                    if (checked) {
                        textArea.isEnabled = false
                        findViewById<RadioButton>(R.id.radio_button_1).isChecked = false
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }

}