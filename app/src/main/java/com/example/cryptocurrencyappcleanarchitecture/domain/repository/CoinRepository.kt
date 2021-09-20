package com.example.cryptocurrencyappcleanarchitecture.domain.repository

import com.example.cryptocurrencyappcleanarchitecture.data.remote.CoinDetailDto
import com.example.cryptocurrencyappcleanarchitecture.data.remote.CoinDto

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId:String): CoinDetailDto

}