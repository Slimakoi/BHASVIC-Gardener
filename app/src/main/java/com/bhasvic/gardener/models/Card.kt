package com.bhasvic.gardener.models

data class Card(
    var name: String,
    var price: String = "",
    var editable: Boolean = true,
    var checked: Boolean = false
)