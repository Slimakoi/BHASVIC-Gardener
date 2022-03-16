package com.bhasvic.gardener.models

data class Card(
    var name: String,
    var price: String = "",
    var editable: Boolean = true,
    var checked: Boolean = false
) {
    @JvmName("setPrice1")
    fun setPrice(editTextValue: String) {
        this.price = editTextValue
    }
}