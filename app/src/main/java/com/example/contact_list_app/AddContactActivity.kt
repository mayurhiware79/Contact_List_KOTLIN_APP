package com.example.contact_list_app

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_contact)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = findViewById<EditText>(R.id.etName)
        val phone = findViewById<EditText>(R.id.etPhone)
        val btn = findViewById<Button>(R.id.btnSave)
        val backIcon = findViewById<ImageView>(R.id.backIconn)

        backIcon.setOnClickListener {
            finish()
        }


        btn.setOnClickListener {
            val nameText = name.text.toString()
            val phoneText = phone.text.toString()

            // ✅ Optional validation
            if (nameText.isEmpty() || phoneText.isEmpty()) {
                Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 🔥 Show Toast
            Toast.makeText(this, "Contact Added Successfully ✅", Toast.LENGTH_SHORT).show()

            val intent = Intent()
            intent.putExtra("name", nameText)
            intent.putExtra("phone", phoneText)

            setResult(RESULT_OK, intent)
            finish()
        }
    }
}