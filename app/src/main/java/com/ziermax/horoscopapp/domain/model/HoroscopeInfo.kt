package com.ziermax.horoscopapp.domain.model

import com.ziermax.horoscopapp.R

sealed class HoroscopeInfo (val imgRef: Int, val nameRef: Int){
	data object Aries: HoroscopeInfo(R.drawable.aries, R.string.aries)
	data object Taurus: HoroscopeInfo(R.drawable.taurus, R.string.taurus)
	data object Geminis: HoroscopeInfo(R.drawable.geminis, R.string.geminis)
	data object Cancer: HoroscopeInfo(R.drawable.cancer, R.string.cancer)
	data object Leo: HoroscopeInfo(R.drawable.leo, R.string.leo)
	data object Virgo: HoroscopeInfo(R.drawable.virgo, R.string.virgo)
	data object Libra: HoroscopeInfo(R.drawable.libra, R.string.libra)
	data object Scorpio: HoroscopeInfo(R.drawable.scorpio, R.string.scorpio)
	data object Sagittarius: HoroscopeInfo(R.drawable.sagittarius, R.string.sagittarius)
	data object Capricorn: HoroscopeInfo(R.drawable.capricorn, R.string.capricorn)
	data object Aquarius: HoroscopeInfo(R.drawable.aquarius, R.string.aquarius)
	data object Pisces: HoroscopeInfo(R.drawable.pisces, R.string.pisces)
}