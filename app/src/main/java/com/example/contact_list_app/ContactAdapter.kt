package com.example.contact_list_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private val list: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageView8)
        val name: TextView = itemView.findViewById(R.id.textView8)
        val phone: TextView = itemView.findViewById(R.id.textView10)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = list[position]

        holder.image.setImageResource(contact.image)
        holder.name.text = contact.name
        holder.phone.text = contact.phone

        // 🔥 CLICK LISTENER
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context

            val intent = android.content.Intent(
                context,
                ContactDetailActivity::class.java
            )

            intent.putExtra("image", contact.image)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = list.size
}