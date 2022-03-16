package com.bhasvic.gardener

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bhasvic.gardener.adapters.CardAdapter
import com.bhasvic.gardener.models.Card
import java.math.BigDecimal
import java.math.RoundingMode


val services = listOf("A", "B", "C")
val goods = listOf("Test 1", "Test 2", "Test 3")
val goods_prices = listOf("9", "10", "21")
const val vat = 1.20

class MainActivity : AppCompatActivity() {
    @SuppressLint("InflateParams", "StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = getString(R.string.top_text)

        // Define the variables
        val cardsList = findViewById<RecyclerView>(R.id.cardsList)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)

        // Define the Card
        val cardAdapter = CardAdapter(this)
        cardsList.adapter = cardAdapter

        // Add the Services
        for (item in services.indices) {
            val toAdd = Card(name = "Services: ${services[item]}")
            cardAdapter.addMessage(toAdd)
        }

        // Add the Goods
        for (item in goods.indices) {
            val toAdd = Card(name = "Goods: ${goods[item]}", price = goods_prices[item], editable = false)
            cardAdapter.addMessage(toAdd)
        }

        buttonCalculate.setOnClickListener {
            // Stuff to check if none of the CheckBoxes are selected
            val tempList = ArrayList<Boolean>()

            for (item in 0 until (services.size + goods.size)) {
                tempList.add(cardAdapter.getItem(item).checked.toString().toBoolean())
            }

            // Check if all of the CheckBoxes are not checked
            val tempFilter = tempList.filter { s -> s }

            if (tempFilter.isEmpty()) {
                Toast.makeText(this, getString(R.string.error_nothing_checked), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Actual stuff
            var pricePart = 0

            for (item in 0 until (services.size + goods.size)) {
                val ca = cardAdapter.getItem(item)

                // If price is empty '0' else 'ca.price'
                val price = ca.price.ifEmpty { "0" }

                if (ca.checked) {
                    pricePart += price.toInt()
                }
            }

            // Display final price
            val finalPrice = BigDecimal(pricePart * vat).setScale(2, RoundingMode.HALF_EVEN)
            Toast.makeText(this, getString(R.string.final_calculation, finalPrice), Toast.LENGTH_SHORT).show()
        }
    }
}
