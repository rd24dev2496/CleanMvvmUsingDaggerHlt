package com.example.cryptocurrencyappcleanarchitecture.domain.use_case.get_coins

import com.example.cryptocurrencyappcleanarchitecture.data.remote.toCoin
import com.example.cryptocurrencyappcleanarchitecture.domain.model.Coin
import com.example.cryptocurrencyappcleanarchitecture.domain.repository.CoinRepository
import com.example.cryptocurrencycleanmvvm.common.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetCoinsUseCase @Inject constructor(private  val repository: CoinRepository){
    operator fun invoke(): kotlinx.coroutines.flow.Flow<Resource<List<Coin>>>  = flow {
        try{
            emit(Resource.Loading())
            val coins=repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        }
        catch (e: HttpException){

        }catch (e: IOException){

        }
    }
}