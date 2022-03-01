package com.bhasvic.gardener.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bhasvic.gardener.models.Card
import com.bhasvic.gardener.R

class CardAdapter(private val ctx: Context) : RecyclerView.Adapter<ServicesViewHolder>() {
    private val messages: ArrayList<Card> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addMessage(message: Card){
        messages.add(message)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        return MyServicesViewHolder(LayoutInflater.from(ctx).inflate(R.layout.card, parent, false))
    }

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        val message = messages[position]
        holder.bind(message)
    }

    inner class MyServicesViewHolder(view: View): ServicesViewHolder(view) {
        private var cardName: TextView = view.findViewById(R.id.cardName)
        private var cardPrice: EditText = view.findViewById(R.id.cardPrice)

        override fun bind(message: Card) {
            cardName.text = message.cardName
            //timeText.text = DateUtils.fromMillisToTimeString(message.time)
        }
    }
}

open class ServicesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    open fun bind(message: Card) {}
}