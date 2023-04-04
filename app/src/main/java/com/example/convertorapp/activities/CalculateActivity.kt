package com.example.convertorapp.activities

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.convertorapp.R
import com.example.convertorapp.data.getDropdownItems
import com.google.android.material.textfield.TextInputLayout


class CalculateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        //Enable the Up button in the Action Bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Get all extras from all the Activities
        val selectedCard = intent.getStringExtra("cardTitle")

        //Assign cardTitle to the Action Bar title (if it exists)
        supportActionBar?.title = selectedCard

        //Remove all inputs focus when clicked aside from the input fields
        val calculateLayout = findViewById<RelativeLayout>(R.id.calculate_layout)
        calculateLayout.setOnClickListener {
            //Hide keyboard and clear focus
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
            it.clearFocus()
        }

        //Drop down unit options
        val optionsField = findViewById<TextInputLayout>(R.id.ti_options_field)
        if (selectedCard != null) {
            val unitsList = getDropdownItems(selectedCard)
            val adapter = ArrayAdapter(this, R.layout.dropdown_unit, unitsList)
            (optionsField.editText as? AutoCompleteTextView)?.setAdapter(adapter)
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
}