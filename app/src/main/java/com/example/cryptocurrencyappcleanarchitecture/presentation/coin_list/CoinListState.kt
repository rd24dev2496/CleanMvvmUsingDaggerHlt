package com.plcoding.cryptocurrencyappyt.presentation.coin_detail.components

import com.example.cryptocurrencyappcleanarchitecture.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)