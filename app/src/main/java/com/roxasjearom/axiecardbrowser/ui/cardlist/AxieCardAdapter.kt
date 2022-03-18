package com.roxasjearom.axiecardbrowser.ui.cardlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.roxasjearom.axiecardbrowser.AxieCard
import com.roxasjearom.axiecardbrowser.databinding.ItemAxieCardBinding

class AxieCardAdapter : RecyclerView.Adapter<AxieCardAdapter.AxieCardViewHolder>() {

    private var axieCards = emptyList<AxieCard>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AxieCardViewHolder {
        val binding = ItemAxieCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AxieCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AxieCardViewHolder, position: Int) {
        val currentItem = axieCards[position]

        holder.binding.cardName.text = currentItem.skillName
    }

    override fun getItemCount(): Int {
        return axieCards.count()
    }

    fun setCards(axieCards: List<AxieCard>) {
        this.axieCards = axieCards
        notifyDataSetChanged()
    }

    inner class AxieCardViewHolder(val binding: ItemAxieCardBinding) :RecyclerView.ViewHolder(binding.root)
}
