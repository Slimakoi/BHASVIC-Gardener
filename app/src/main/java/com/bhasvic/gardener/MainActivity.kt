package com.bhasvic.gardener

import android.annotation.SuppressLint
import android.app.Service
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.PopupWindow
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bhasvic.gardener.adapters.CardAdapter
import com.bhasvic.gardener.adapters.ServicesViewHolder
import com.bhasvic.gardener.models.Card

val services = listOf("Test A", "Test B", "Test C")
val goods = listOf("Test 1", "Test 2", "Test 3")

var srv = ArrayList<Card>()
var gds = ArrayList<Card>()

class MainActivity : AppCompatActivity() {
    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Define the variables
        val cardsList = findViewById<RecyclerView>(R.id.cardsList)
        val buttonCalculate = findViewById<Button>(R.id.button_calculate)

        // Define the Card
        val cardAdapter = CardAdapter(this)
        cardsList.adapter = cardAdapter


        // Add the Services
        for (item in services.indices) {
            val toAdd = Card(cardName = "Services: ${services[item]}")
            srv.add(toAdd)
            cardAdapter.addMessage(toAdd)
        }

        // Add the Goods
        for (item in goods.indices) {
            val toAdd = Card(cardName = "Goods: ${goods[item]}")
            gds.add(toAdd)
            cardAdapter.addMessage(toAdd)
        }

        buttonCalculate.setOnClickListener {
            println("Items below : (stuff here from the EditText's Card's)")
        }
    }
}