package com.example.convertorapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.convertorapp.R
import com.example.convertorapp.data.CardRVAdapter
import com.example.convertorapp.data.initCardList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Hide the Action Bar if it is not null.
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        //Initialize Recycler View with its ID
        val cardRV = findViewById<RecyclerView>(R.id.rv_cards_list)
        //Initialize card list using the initCardList function
        val cardList = initCardList()

        //Variable for grid layout manager with 2 columns and apply it to the Recycler View
        val layoutManager = GridLayoutManager(this, 2)
        cardRV.layoutManager = layoutManager

        //Initialize Recycler View's Adapter and set it up to Recycler View
        //Clicking a card will navigate and start the CalculateActivity
        val cardRVAdapter = CardRVAdapter(cardList, this) { _, cardTitle ->
            val intent = Intent(this, CalculateActivity::class.java)
            //Send the specific card title to the CalculateActivity
            intent.putExtra("cardTitle", cardTitle)
            startActivity(intent)
        }
        cardRV.adapter = cardRVAdapter

        //Notify the adapter that data has been updated
        cardRVAdapter.notifyDataSetChanged()

    }
}