package com.example.contact_list_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var contactList: ArrayList<Contact>
    lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val fab = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fabAdd)

        // 🔥 Initialize list
        contactList = ArrayList()

        val names = arrayOf(
            "Mayur Hiware",
            "Rahul Sharma",
            "Amit Joshi",
            "Priya Deshmukh"
        )

        val phones = arrayOf(
            "8379071012",
            "9876543210",
            "9988776655",
            "9123456789"
        )

        val images = Array(names.size) { R.drawable.person_icon }

        for (i in names.indices) {
            contactList.add(Contact(images[i], names[i], phones[i]))
        }

        // 🔥 Setup adapter
        adapter = ContactAdapter(contactList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // 🔥 Result launcher
        val launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val name = data?.getStringExtra("name")
                val phone = data?.getStringExtra("phone")

                if (name != null && phone != null) {
                    contactList.add(Contact(R.drawable.person_icon, name, phone))
                    adapter.notifyItemInserted(contactList.size - 1)
                }
            }
        }

        // 🔥 FAB click
        fab.setOnClickListener {
            val intent = Intent(this, AddContactActivity::class.java)
            launcher.launch(intent)
        }
    }
}