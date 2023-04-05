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
    cardList.add(CardRVModal("Length", R.drawable.ic_length_card))
    cardList.add(CardRVModal("Area", R.drawable.ic_area_card))
    cardList.add(CardRVModal("Volume", R.drawable.ic_volume_card))
    cardList.add(CardRVModal("Mass", R.drawable.ic_mass_card))
    cardList.add(CardRVModal("Weight", R.drawable.ic_weight_card))
    cardList.add(CardRVModal("Time", R.drawable.ic_time_card))
    cardList.add(CardRVModal("Electric current", R.drawable.ic_electriccurrent_card))
    cardList.add(CardRVModal("Temperature", R.drawable.ic_temperature_card))
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
        "Time" -> listOf("Second", "Minute", "Hour", "Day", "Week", "Month", "Year")
        "Electric current" -> listOf("Ampere", "Milliampere", "Microampere")
        "Temperature" -> listOf("Celsius", "Fahrenheit", "Kelvin")
        else -> emptyList()
    }
}

//Conversion data
//LENGTH
data class LengthConversionValues(
    val meter: Double,
    val centimeter: Double,
    val inch: Double,
    val foot: Double,
)
//LENGTH CONVERSION FORMULA
val LengthConversionMap = mapOf(
    "Meter" to LengthConversionValues(1.0, 100.0, 39.37, 3.28),
    "Centimeter" to LengthConversionValues(0.01, 1.0, 0.39, 0.03),
    "Inch" to LengthConversionValues(0.0254, 2.54, 1.0, 0.083333),
    "Foot" to LengthConversionValues(0.3048, 30.48, 12.0, 1.0),
)

//AREA
data class AreaConversionValues(
    val sqrMeter: Double,
    val sqrCentimeter: Double,
    val sqrInch: Double,
    val sqrFoot: Double,
)
//AREA CONVERSION FORMULA
val AreaConversionMap = mapOf(
    "Square Meter" to AreaConversionValues(1.0, 10000.0, 1550.0031, 10.7639),
    "Square Centimeter" to AreaConversionValues(0.0001, 1.0, 0.0016, 0.000010764),
    "Square Inch" to AreaConversionValues(0.00064516, 6.4516, 1.0, 0.00694444),
    "Square Foot" to AreaConversionValues(0.092903, 929.0304, 144.0, 1.0),
)

//VOLUME
data class VolumeConversionValues(
    val cubMeter: Double,
    val cubCentimeter: Double,
    val cubInch: Double,
    val cubFoot: Double,
)
//VOLUME CONVERSION FORMULA
val VolumeConversionMap = mapOf(
    "Cubic Meter" to VolumeConversionValues(1.0, 1000000.0, 61023.7, 35.3147),
    "Cubic Centimeter" to VolumeConversionValues(0.000001, 1.0, 0.0610237, 0.0000353147),
    "Cubic Inch" to VolumeConversionValues(0.0000163871, 16.3871, 1.0, 0.000578704),
    "Cubic Foot" to VolumeConversionValues(0.0283168, 28316.8, 1728.0, 1.0),
)

//MASS
data class MassConversionValues(
    val kilogram: Double,
    val gram: Double,
    val ounce: Double,
    val pound: Double,
)
//MASS CONVERSION FORMULA
val MassConversionMap = mapOf(
    "Kilogram" to MassConversionValues(1.0, 1000.0, 35.274, 2.205),
    "Gram" to MassConversionValues(0.001, 1.0, 0.0353, 0.0022),
    "Ounce" to MassConversionValues(0.0283, 28.3495, 1.0, 0.0625),
    "Pound" to MassConversionValues(0.4536, 453.592, 16.0, 1.0),
)

//WEIGHT
data class WeightConversionValues(
    val newton: Double,
    val kilopond: Double,
    val poundForce: Double
)
//WEIGHT CONVERSION FORMULA
val WeightConversionMap = mapOf(
    "Newton" to WeightConversionValues(1.0, 0.10197, 0.22481),
    "Kilopond" to WeightConversionValues(9.80665, 1.0, 2.20462),
    "Pound-Force" to WeightConversionValues(4.44822, 0.45359, 1.0),
)

//TIME
data class TimeConversionValues(
    val second: Double,
    val minute: Double,
    val hour: Double,
    val day: Double,
    val week: Double,
    val month: Double,
    val year: Double,
)
//TIME CONVERSION FORMULA
val TimeConversionMap = mapOf(
    "Second" to TimeConversionValues(1.0, 0.0166667, 0.000277778, 0.0000115741, 0.00000165344, 0.000000380517, 0.0000000316881),
    "Minute" to TimeConversionValues(60.0, 1.0, 0.0166667, 0.000694444, 0.0000992063, 0.0000228311, 0.00000190133),
    "Hour" to TimeConversionValues(3600.0, 60.0, 1.0, 0.0416667, 0.00595238, 0.00136895, 0.00011408),
    "Day" to TimeConversionValues(86400.0, 1440.0, 24.0, 1.0, 0.142857, 0.0328767, 0.00273973),
    "Week" to TimeConversionValues(604800.0, 10080.0, 168.0, 7.0, 1.0, 0.229985, 0.0191781),
    "Month" to TimeConversionValues(2629800.0, 43830.0, 730.5, 30.4375, 4.34812, 1.0, 0.0833333),
    "Year" to TimeConversionValues(31557600.0, 525960.0, 8760.0, 365.25, 52.1786, 12.0, 1.0)
)

//ELECTRIC CURRENT
data class ElectricCurrentConversionValues(
    val ampere: Double,
    val milliAmpere: Double,
    val microAmpere: Double,
)
//ELECTRIC CURRENT CONVERSION FORMULA
val ElectricCurrentConversionMap = mapOf(
    "Ampere" to ElectricCurrentConversionValues(1.0, 1000.0, 1000000.0),
    "Milliampere" to ElectricCurrentConversionValues(0.001, 1.0, 1000.0),
    "Microampere" to ElectricCurrentConversionValues(0.000001, 0.001, 1.0)
)

//TEMPERATURE
data class TemperatureConversionValues(
    val celsius: (Double) -> Double,
    val fahrenheit: (Double) -> Double,
    val kelvin: (Double) -> Double,
)
//TEMPERATURE CONVERSION FORMULA
val TemperatureConversionMap = mapOf(
    "Celsius" to TemperatureConversionValues(
        celsius = { it },
        fahrenheit = { it * 9.0 / 5.0 + 32.0 },
        kelvin = { it + 273.15 }
    ),
    "Fahrenheit" to TemperatureConversionValues(
        celsius = { (it - 32.0) * 5.0 / 9.0 },
        fahrenheit = { it },
        kelvin = { (it + 459.67) * 5.0 / 9.0 }
    ),
    "Kelvin" to TemperatureConversionValues(
        celsius = { it - 273.15 },
        fahrenheit = { it * 9.0 / 5.0 - 459.67 },
        kelvin = { it }
    )
)