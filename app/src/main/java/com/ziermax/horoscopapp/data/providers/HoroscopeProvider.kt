package com.ziermax.horoscopapp.data.providers

import com.ziermax.horoscopapp.domain.model.HoroscopeInfo
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
	fun getHoroscopeList():List<HoroscopeInfo> {
		return (listOf(
			HoroscopeInfo.Aries,
			HoroscopeInfo.Geminis,
			HoroscopeInfo.Taurus,
			HoroscopeInfo.Leo,
			HoroscopeInfo.Libra,
			HoroscopeInfo.Cancer,
			HoroscopeInfo.Pisces,
			HoroscopeInfo.Sagittarius,
			HoroscopeInfo.Scorpio,
			HoroscopeInfo.Capricorn,
			HoroscopeInfo.Aquarius))
	}
}