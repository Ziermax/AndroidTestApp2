package com.ziermax.horoscopapp.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.ziermax.horoscopapp.R
import com.ziermax.horoscopapp.domain.model.HoroscopeInfo
import com.ziermax.horoscopapp.ui.horoscope.HoroscopeViewModel

class HoroscopeAdapter(
	private var horoscopeList: List<HoroscopeInfo> = emptyList(),
	private val onItemSelected: (HoroscopeInfo) -> Unit
) : RecyclerView.Adapter<HoroscopeViewHolder>() {

	fun updateList(list: List<HoroscopeInfo>) {
		horoscopeList = list
		notifyDataSetChanged()
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
		return (HoroscopeViewHolder(
			LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
		))
	}

	override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
		holder.render(horoscopeList[position], onItemSelected)
	}

	override fun getItemCount(): Int = horoscopeList.size
}