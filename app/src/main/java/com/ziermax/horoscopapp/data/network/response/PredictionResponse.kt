package com.ziermax.horoscopapp.data.network.response

import com.google.gson.annotations.SerializedName

data class PredictionResponse (
	@SerializedName("date") val date: String,
	@SerializedName("horoscope") val horoscopeQuote: String,
	@SerializedName("sign") val sign: String,
)