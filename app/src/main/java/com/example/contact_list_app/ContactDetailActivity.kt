package com.example.contact_list_app

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContactDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_detail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 🔥 STEP 1: Find Views
        val image = findViewById<ImageView>(R.id.detailImage)
        val name = findViewById<TextView>(R.id.detailName)
        val phone = findViewById<TextView>(R.id.detailPhone)
//        val backBtn = findViewById<Button>(R.id.backBtn)
//
//        backBtn.setOnClickListener {
//            finish()
//        }

        val backIcon = findViewById<ImageView>(R.id.backIcon)

        backIcon.setOnClickListener {
            finish()
        }

        // 🔥 STEP 2: Get Data from Intent
        val img = intent.getIntExtra("image", 0)
        val nm = intent.getStringExtra("name")
        val ph = intent.getStringExtra("phone")

        // 🔥 STEP 3: Set Data to UI
        image.setImageResource(img)
        name.text = nm
        phone.text = ph
    }
}