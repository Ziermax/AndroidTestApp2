package com.ziermax.horoscopapp.data.network

import android.gesture.Prediction
import com.ziermax.horoscopapp.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {

	@GET("/{sign}")
	suspend fun getHoroscope(@Path("sign")sign: String): PredictionResponse

}