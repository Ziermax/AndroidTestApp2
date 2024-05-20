package com.ziermax.horoscopapp.domain

interface Repository {
	suspend fun getPrediction (sign: String)
}