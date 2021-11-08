package com.example.myfirstlowkeyadvancedapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // "%.2f".format(2.00).toString().toDouble()

        val btmNavMenu: BottomNavigationView = findViewById(R.id.bottom_nav)
        btmNavMenu.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.left_nav -> startActivity(Intent(this, Activity1::class.java))
                R.id.centre_nav -> startActivity(Intent(this, Activity2::class.java))
                R.id.right_nav -> startActivity(Intent(this, Activity3::class.java))
            }
            true
        }

    }

    fun startAct1(v: View) {
        val myIntent = Intent(this, Activity1::class.java)
        startActivity(myIntent)
    }

    fun startAct2(v: View) {
        val myIntent = Intent(this, Activity2::class.java)
        startActivity(myIntent)
    }

    fun startAct3(v: View) {
        val myIntent = Intent(this, Activity3::class.java)
        startActivity(myIntent)
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}
