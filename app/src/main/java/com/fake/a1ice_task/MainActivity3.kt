package com.fake.a1ice_task

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)


        val goToCalc = findViewById<Button>(R.id.GoToCalc)
        val comingSoon = findViewById<Button>(R.id.comingsoon)
        val profile = findViewById<Button>(R.id.profile)

        profile.setOnClickListener {
            val intent = Intent(this, ProfilePicture::class.java)
            startActivity(intent)
        }

        goToCalc.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        comingSoon.setOnClickListener{
            Toast.makeText(applicationContext, "This feature is coming soon", Toast.LENGTH_LONG).show()
        }
        }

        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            //val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            //insets
        }
