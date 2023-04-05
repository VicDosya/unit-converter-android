package com.example.convertorapp.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.convertorapp.R

//Create a Recycler View adapter class
class CardRVAdapter(
    //Passing variables as card list, context and click listener
    private val cardList: ArrayList<CardRVModal>,
    private val context: Context,
    private val clickListener: (position: Int, cardTitle: String) -> Unit
) : RecyclerView.Adapter<CardRVAdapter.CardViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardRVAdapter.CardViewHolder {
        //This method is used to inflate the layout file
        //Which is created for the recycler view
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_card, parent, false
        )
        //Return the view holder class with the item View file
        return CardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardRVAdapter.CardViewHolder, position: Int) {
        //Set up the data to the card TextView and card ImageView
        //Set up the click listener
        holder.cardTitle.text = cardList[position].cardTitle
        holder.cardImage.setImageResource(cardList[position].CardImg)
        holder.itemView.setOnClickListener { clickListener(position, cardList[position].cardTitle) }

    }

    override fun getItemCount(): Int {
        //Return the size of the card list
        return cardList.size
    }

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Initialize the card title TextView and the card image ImageView
        val cardTitle: TextView = itemView.findViewById(R.id.tv_card_title)
        val cardImage: ImageView = itemView.findViewById(R.id.iv_card_image)
    }
}
