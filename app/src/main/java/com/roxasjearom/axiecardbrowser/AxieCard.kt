package com.roxasjearom.axiecardbrowser

data class AxieCard(
    val id: String,
    val defaultAttack: Int,
    val defaultDefense: Int,
    val defaultEnergy: Int,
    val description: String,
    val expectType: String,
    val iconId: String,
    val partName: String,
    val skillName: String,
    val triggerColor: String,
    val triggerText: String
)