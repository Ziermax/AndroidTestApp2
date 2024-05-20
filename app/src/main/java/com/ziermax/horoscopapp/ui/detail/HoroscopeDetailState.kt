package com.ziermax.horoscopapp.ui.detail

sealed class HoroscopeDetailState {
	data object Loading : HoroscopeDetailState()
	data class Error(val errorStr: String) : HoroscopeDetailState()
	data class Success(val data: String) : HoroscopeDetailState()
}