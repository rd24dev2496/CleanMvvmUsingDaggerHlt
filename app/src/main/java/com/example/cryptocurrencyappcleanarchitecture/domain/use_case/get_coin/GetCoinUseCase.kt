package com.example.cryptocurrencyappcleanarchitecture.domain.use_case.get_coin

import com.example.cryptocurrencyappcleanarchitecture.data.remote.toCoinDetail
import com.example.cryptocurrencyappcleanarchitecture.domain.model.CoinDetail
import com.example.cryptocurrencyappcleanarchitecture.domain.repository.CoinRepository
import com.example.cryptocurrencycleanmvvm.common.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private  val repository: CoinRepository){
    operator fun invoke(coinId:String): kotlinx.coroutines.flow.Flow<Resource<CoinDetail>>  = flow {
        try{
            emit(Resource.Loading())
            val coin=repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))

        }
        catch (e: HttpException){

        }catch (e: IOException){

        }
    }
}