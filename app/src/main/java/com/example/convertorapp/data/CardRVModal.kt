package com.example.convertorapp.data

import com.example.convertorapp.R

data class CardRVModal(
    //Each card will contain an image and a title
    val cardTitle: String,
    val CardImg: Int
)

//Initialize card list data function (Function is used in MainActivity)
fun initCardList(): ArrayList<CardRVModal> {
    val cardList = ArrayList<CardRVModal>()
    cardList.add(CardRVModal("Length", R.drawable.ic_launcher_background))
    cardList.add(CardRVModal("Area", R.drawable.ic_launcher_background))
    cardList.add(CardRVModal("Volume", R.drawable.ic_launcher_background))
    cardList.add(CardRVModal("Mass", R.drawable.ic_launcher_background))
    cardList.add(CardRVModal("Weight", R.drawable.ic_launcher_background))
    cardList.add(CardRVModal("Time", R.drawable.ic_launcher_background))
    cardList.add(CardRVModal("Electric current", R.drawable.ic_launcher_background))
    cardList.add(CardRVModal("Temperature", R.drawable.ic_launcher_background))
    return cardList
}

//Function that takes the selectedCard as an argument and returns a list of dropdown items
//for that specific card title
fun getDropdownItems(cardTitle: String): List<String> {
    return when (cardTitle) {
        "Length" -> listOf("Meter", "Centimeter", "Inch", "Foot")
        "Area" -> listOf("Square Meter", "Square Centimeter", "Square Inch", "Square Foot")
        "Volume" -> listOf("Cubic Meter", "Cubic Centimeter", "Cubic Inch", "Cubic Foot")
        "Mass" -> listOf("Kilogram", "Gram", "Ounce", "Pound")
        "Weight" -> listOf("Newton", "Kilopond", "Pound-Force")
        "Time" -> listOf("Second", "Minute", "Hour", "Day")
        "Electric current" -> listOf("Ampere", "Milliampere", "Microampere")
        "Temperature" -> listOf("Celsius", "Fahrenheit", "Kelvin")
        else -> emptyList()
    }
}