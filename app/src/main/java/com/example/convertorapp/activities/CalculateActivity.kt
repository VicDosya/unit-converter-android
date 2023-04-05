package com.example.convertorapp.activities

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.TypedValue
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.convertorapp.R
import com.example.convertorapp.data.*
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class CalculateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        //Views variables
        //Relative Layout View
        val calculateLayout = findViewById<RelativeLayout>(R.id.calculate_layout)
        //Linear Layout View
        val linearLayout = findViewById<LinearLayout>(R.id.unit_linear_layout)
        //Number input layout + input value
        val textInputLayout = findViewById<TextInputLayout>(R.id.ti_number_input)
        val numberInput = findViewById<TextInputEditText>(R.id.et_number_input)
        //Dropdown menu layout + input value
        val optionsField = findViewById<TextInputLayout>(R.id.ti_options_field)
        val chosenOption = findViewById<AutoCompleteTextView>(R.id.tv_auto_complete)
        //Button View
        val convertButton = findViewById<Button>(R.id.convert_button)

        //Get all extras from all the Activities
        val selectedCard = intent.getStringExtra("cardTitle")


        //Remove all inputs focus when clicked aside from the input fields
        calculateLayout.setOnClickListener {
            //Hide keyboard and clear focus
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
            it.clearFocus()
        }

        //Drop down unit options
        if (selectedCard != null) {
            val unitsList = getDropdownItems(selectedCard)
            val adapter = ArrayAdapter(this, R.layout.dropdown_unit, unitsList)
            (optionsField.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        }

        //Set toolbar function with its selected card title
        setToolBar(selectedCard)

        //Convert button click listener
        convertButton.setOnClickListener {
            //If number input is empty, send layout error
            if (numberInput.text.isNullOrEmpty()) {
                textInputLayout.error = "Fill in a number"
                //if no unit has been chosen at the dropbox layout, send layout error
            } else if (chosenOption.text.isNullOrEmpty()) {
                optionsField.error = "Choose a unit"
                //Send conversion data
            } else {
                //Remove error lines (in case they exist)
                textInputLayout.isErrorEnabled = false
                optionsField.isErrorEnabled = false
                //Remove all current converted TextViews
                linearLayout.removeAllViewsInLayout()
                //Get input number value
                val number = numberInput.text.toString().toDoubleOrNull()
                //Handle conversion for each card
                when (selectedCard) {
                    "Length" -> {
                        //Values variables
                        val conversionValues = LengthConversionMap[chosenOption.text.toString()]
                        val meterValue = number?.times(conversionValues!!.meter)
                        val centimeterValue = number?.times(conversionValues!!.centimeter)
                        val inchValue = number?.times(conversionValues!!.inch)
                        val footValue = number?.times(conversionValues!!.foot)
                        //Display Data
                        addTextViews(linearLayout, "Meter", meterValue)
                        addTextViews(linearLayout, "Centimeter", centimeterValue)
                        addTextViews(linearLayout, "Inch", inchValue)
                        addTextViews(linearLayout, "Foot", footValue)
                    }
                    "Area" -> {
                        //Values variables
                        val conversionValues = AreaConversionMap[chosenOption.text.toString()]
                        val sqrMeterValue = number?.times(conversionValues!!.sqrMeter)
                        val sqrCentimeterValue = number?.times(conversionValues!!.sqrCentimeter)
                        val sqrInchValue = number?.times(conversionValues!!.sqrInch)
                        val sqrFootValue = number?.times(conversionValues!!.sqrFoot)
                        //Display Data
                        addTextViews(linearLayout, "Square Meter", sqrMeterValue)
                        addTextViews(linearLayout, "Square Centimeter", sqrCentimeterValue)
                        addTextViews(linearLayout, "Square Inch", sqrInchValue)
                        addTextViews(linearLayout, "Square Foot", sqrFootValue)
                    }
                    "Volume" -> {
                        //Values variables
                        val conversionValues = VolumeConversionMap[chosenOption.text.toString()]
                        val cubMeterValue = number?.times(conversionValues!!.cubMeter)
                        val cubCentimeterValue = number?.times(conversionValues!!.cubCentimeter)
                        val cubInchValue = number?.times(conversionValues!!.cubInch)
                        val cubFootValue = number?.times(conversionValues!!.cubFoot)
                        //Display Data
                        addTextViews(linearLayout, "Cubic Meter", cubMeterValue)
                        addTextViews(linearLayout, "Cubic Centimeter", cubCentimeterValue)
                        addTextViews(linearLayout, "Cubic Inch", cubInchValue)
                        addTextViews(linearLayout, "Cubic Foot", cubFootValue)
                    }
                    "Mass" -> {
                        //Values variables
                        val conversionValues = MassConversionMap[chosenOption.text.toString()]
                        val kilogramValue = number?.times(conversionValues!!.kilogram)
                        val gramValue = number?.times(conversionValues!!.gram)
                        val ounceValue = number?.times(conversionValues!!.ounce)
                        val poundValue = number?.times(conversionValues!!.pound)
                        //Display Data
                        addTextViews(linearLayout, "Kilogram", kilogramValue)
                        addTextViews(linearLayout, "Gram", gramValue)
                        addTextViews(linearLayout, "Ounce", ounceValue)
                        addTextViews(linearLayout, "Pound", poundValue)
                    }
                    "Weight" -> {
                        //Values variables
                        val conversionValues = WeightConversionMap[chosenOption.text.toString()]
                        val newtonValue = number?.times(conversionValues!!.newton)
                        val kilopondValue = number?.times(conversionValues!!.kilopond)
                        val poundForceValue = number?.times(conversionValues!!.poundForce)
                        //Display Data
                        addTextViews(linearLayout, "Newton", newtonValue)
                        addTextViews(linearLayout, "Kilopond", kilopondValue)
                        addTextViews(linearLayout, "Pound-Force", poundForceValue)
                    }
                    "Time" -> {
                        //Values variables
                        val conversionValues = TimeConversionMap[chosenOption.text.toString()]
                        val secondValue = number?.times(conversionValues!!.second)
                        val minuteValue = number?.times(conversionValues!!.minute)
                        val hourValue = number?.times(conversionValues!!.hour)
                        val dayValue = number?.times(conversionValues!!.day)
                        val weekValue = number?.times(conversionValues!!.week)
                        val monthValue = number?.times(conversionValues!!.month)
                        val yearValue = number?.times(conversionValues!!.year)
                        //Display Data
                        addTextViews(linearLayout, "Second", secondValue)
                        addTextViews(linearLayout, "Minute", minuteValue)
                        addTextViews(linearLayout, "Hour", hourValue)
                        addTextViews(linearLayout, "Day", dayValue)
                        addTextViews(linearLayout, "Week", weekValue)
                        addTextViews(linearLayout, "Month", monthValue)
                        addTextViews(linearLayout, "Year", yearValue)
                    }
                    "Electric current" -> {
                        //Values variables
                        val conversionValues =
                            ElectricCurrentConversionMap[chosenOption.text.toString()]
                        val ampereValue = number?.times(conversionValues!!.ampere)
                        val milliAmpereValue = number?.times(conversionValues!!.milliAmpere)
                        val microAmpereValue = number?.times(conversionValues!!.microAmpere)
                        //Display Data
                        addTextViews(linearLayout, "Ampere", ampereValue)
                        addTextViews(linearLayout, "Milliampere", milliAmpereValue)
                        addTextViews(linearLayout, "Microampere", microAmpereValue)
                    }
                    "Temperature" -> {
                        //Values variables
                        val conversionValues =
                            TemperatureConversionMap[chosenOption.text.toString()]
                        val celsiusValue = conversionValues?.celsius?.invoke(number!!)
                        val fahrenheitValue = conversionValues?.fahrenheit?.invoke(number!!)
                        val kelvinValue = conversionValues?.kelvin?.invoke(number!!)
                        //Display Data
                        addTextViews(linearLayout, "Celsius", celsiusValue)
                        addTextViews(linearLayout, "Fahrenheit", fahrenheitValue)
                        addTextViews(linearLayout, "Kelvin", kelvinValue)
                    }
                }
            }
        }
    }

    //Enable the back button to finish the CalculateActivity
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Handle Up button click
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    //Function to add new TextViews in the LinearLayout
    private fun addTextViews(linearLayout: LinearLayout, unit: String, unitValue: Double?) {
        val textView = TextView(this)
        textView.text = getString(R.string.unit_value_template, unit, unitValue)
        //Text styling
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        textView.setTypeface(null,Typeface.BOLD)
        textView.setTextColor(ContextCompat.getColor(this,android.R.color.black))
        textView.setLineSpacing(16f, 2f)
        //Add text view to the linearLayout
        linearLayout.addView(textView)
    }

    //Assign cardTitle to the Action Bar title (if it exists)
    //Set its text color to black
    //Include back arrow button
    private fun setToolBar(selectedCard: String?) {
        //Enable the Up button in the Action Bar
        supportActionBar?.apply {
            setBackgroundDrawable(ColorDrawable(Color.WHITE))
            setHomeAsUpIndicator(com.google.android.material.R.drawable.ic_arrow_back_black_24)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        val spannableString = SpannableString(selectedCard)
        spannableString.setSpan(
            ForegroundColorSpan(Color.BLACK),
            0,
            selectedCard!!.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.title = spannableString
    }
}