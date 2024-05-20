package com.ziermax.horoscopapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.ziermax.horoscopapp.databinding.ItemHoroscopeBinding
import com.ziermax.horoscopapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

	private val binding: ItemHoroscopeBinding = ItemHoroscopeBinding.bind(view)

	fun render(
		horoscopeInfo: HoroscopeInfo,
		onItemSelected: (HoroscopeInfo) -> Unit
	) {
		binding.parentHoroscopeItem.setOnClickListener {
			startRotationAnimation(binding.ivHoroscopeItem, afterAnimation = { onItemSelected(horoscopeInfo) })
		}
		val context = binding.tvHoroscopeItem.context
		binding.tvHoroscopeItem.text = context.getString(horoscopeInfo.nameRef)
		binding.ivHoroscopeItem.setImageResource(horoscopeInfo.imgRef)
	}

	private fun startRotationAnimation(view: View, afterAnimation: () -> Unit) {
		view.animate().apply {
			duration = 250
			interpolator = LinearInterpolator()
			rotation(360f)
			withEndAction { afterAnimation() }
			start()
		}
	}
}