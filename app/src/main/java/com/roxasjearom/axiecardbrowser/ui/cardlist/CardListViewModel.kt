package com.roxasjearom.axiecardbrowser.ui.cardlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roxasjearom.axiecardbrowser.AxieCard
import com.roxasjearom.axiecardbrowser.network.AxieCardsApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.lang.Exception


class CardListViewModel : ViewModel() {

    private val eventChannel = Channel<String>()
    val eventFlow = eventChannel.receiveAsFlow()

    private var _cardList = MutableLiveData<List<AxieCard>>()
    val cardList: LiveData<List<AxieCard>> = _cardList

    init {
        getCards()
    }

    private fun getCards() {
        viewModelScope.launch {
            try {
                val result = AxieCardsApi.retrofitService.getCards()
                _cardList.value = result
                Log.e("RESPONSE", result.toString())
                eventChannel.send("Success")
            } catch (e: Exception) {
                eventChannel.send("Failed")
                Log.e("ERROR", e.toString())
            }
        }
    }

}
