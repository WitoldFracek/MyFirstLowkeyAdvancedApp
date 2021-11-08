package com.example.myfirstlowkeyadvancedapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.view.MenuItem
import android.widget.SeekBar
import android.widget.TextView

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val barVal: TextView = findViewById(R.id.bar_result)

        val seekBar: SeekBar = findViewById(R.id.bar_number_setter)
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                barVal.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        barVal.text = seekBar.progress.toString()
    }

    fun backAct3(v: View) {
        val myIntent = Intent(this, MainActivity::class.java)
        startActivity(myIntent)
        finish()
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }


}