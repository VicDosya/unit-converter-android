package com.example.convertorapp.data

import com.example.convertorapp.R

data class CardRVModal(
    //Each card will contain an image and a title
    val cardTitle: String,
    val CardImg: Int
)

//Initialize card list data function (Function is used in MainActivity)
public fun initCardList(): ArrayList<CardRVModal> {
    val cardList = ArrayList<CardRVModal>()
    cardList.add(CardRVModal("Length", R.drawable.ic_launcher_background))
    cardList.add(CardRVModal("Area", R.drawable.ic_launcher_background))
    cardList.add(CardRVModal("Volume", R.drawable.ic_launcher_background))
    cardList.add(CardRVModal("Mass", R.drawable.ic_launcher_background))
    cardList.add(CardRVModal("Weight", R.drawable.ic_launcher_background))
    cardList.add(CardRVModal("Time", R.drawable.ic_launcher_background))
    return cardList
}
