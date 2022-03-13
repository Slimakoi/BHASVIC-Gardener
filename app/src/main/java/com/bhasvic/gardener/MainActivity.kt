package com.bhasvic.gardener

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal
import java.math.RoundingMode


class MainActivity : AppCompatActivity() {
    @SuppressLint("InflateParams", "StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Define the variables
        val cardPriceOne = findViewById<EditText>(R.id.cardPriceOne)
        val cardPriceTwo = findViewById<EditText>(R.id.cardPriceTwo)
        val cardPriceThree = findViewById<EditText>(R.id.cardPriceThree)
        val cardPriceFour = findViewById<EditText>(R.id.cardPriceFour)
        val cardPriceFive = findViewById<EditText>(R.id.cardPriceFive)
        val cardPriceSix = findViewById<EditText>(R.id.cardPriceSix)
        val cardCheckOne = findViewById<CheckBox>(R.id.cardCheckOne)
        val cardCheckTwo = findViewById<CheckBox>(R.id.cardCheckTwo)
        val cardCheckThree = findViewById<CheckBox>(R.id.cardCheckThree)
        val cardCheckFour = findViewById<CheckBox>(R.id.cardCheckFour)
        val cardCheckFive = findViewById<CheckBox>(R.id.cardCheckFive)
        val cardCheckSix = findViewById<CheckBox>(R.id.cardCheckSix)
        val buttonCalculate = findViewById<Button>(R.id.button_calculate)


        /*
        code for adapters, not working 100%

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
        */

        buttonCalculate.setOnClickListener {
            if (!cardCheckOne.isChecked and
                !cardCheckTwo.isChecked and
                !cardCheckThree.isChecked and
                !cardCheckFour.isChecked and
                !cardCheckFive.isChecked and
                !cardCheckSix.isChecked
            ) {
                Toast.makeText(this, getString(R.string.error_nothing_checked), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val priceOne = if (cardCheckOne.isChecked) { try { cardPriceOne.text.toString().toInt() } catch (empty: NumberFormatException) { 0 } } else ( 0 )
            val priceTwo = if (cardCheckTwo.isChecked) { try { cardPriceTwo.text.toString().toInt() } catch (empty: NumberFormatException) { 0 } } else ( 0 )
            val priceThree = if (cardCheckThree.isChecked) { try { cardPriceThree.text.toString().toInt() } catch (empty: NumberFormatException) { 0 } } else ( 0 )
            val priceFour = if (cardCheckFour.isChecked) { try { cardPriceFour.text.toString().toInt() } catch (empty: NumberFormatException) { 0 } } else ( 0 )
            val priceFive = if (cardCheckFive.isChecked) { try { cardPriceFive.text.toString().toInt() } catch (empty: NumberFormatException) { 0 } } else ( 0 )
            val priceSix = if (cardCheckSix.isChecked) { try { cardPriceSix.text.toString().toInt() } catch (empty: NumberFormatException) { 0 } } else ( 0 )

            val finalPrice = BigDecimal((priceOne + priceTwo + priceThree + priceFour + priceFive + priceSix) * 1.20).setScale(2, RoundingMode.HALF_EVEN)
            Toast.makeText(this, getString(R.string.final_calculation, finalPrice), Toast.LENGTH_SHORT).show()
        }
    }
}