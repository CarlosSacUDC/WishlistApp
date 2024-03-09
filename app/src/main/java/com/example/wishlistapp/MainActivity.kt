package com.example.wishlistapp

import ListAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val wishlist = findViewById<RecyclerView>(R.id.wishlistRv)
        val name = findViewById<EditText>(R.id.nameEt)
        val price = findViewById<EditText>(R.id.priceEt)
        val link = findViewById<EditText>(R.id.linkEt)
        val submit = findViewById<Button>(R.id.submit)

        val adapter = ListAdapter(ItemList.getItems())
        wishlist.adapter = adapter
        wishlist.layoutManager = LinearLayoutManager(this)

        submit.setOnClickListener {
            val nameText = name.text.toString()
            var priceText = price.text.toString()
            val linkText = link.text.toString()

            if (nameText.isBlank()) {
                Toast.makeText(this, "Please add item name", Toast.LENGTH_SHORT).show()
            } else {
                val priceFloat = priceText.toFloatOrNull() ?: 0f
                priceText = "$" + "%.2f".format(priceFloat)

                val newItem = Wishlist(nameText, priceText, linkText)
                ItemList.addItem(newItem)
                adapter.notifyDataSetChanged()

            }

            name.text.clear()
            price.text.clear()
            link.text.clear()
        }
    }

    object ItemList{
        private var items = mutableListOf<Wishlist>()

        fun addItem(item: Wishlist) {
            items.add(item)
        }

        fun getItems(): List<Wishlist> {
            return items

        }


    }


}