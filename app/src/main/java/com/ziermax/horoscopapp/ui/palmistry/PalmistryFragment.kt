package com.ziermax.horoscopapp.ui.palmistry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ziermax.horoscopapp.R
import com.ziermax.horoscopapp.databinding.FragmentLuckBinding
import com.ziermax.horoscopapp.databinding.FragmentPalmistryBinding
import com.ziermax.horoscopapp.ui.horoscope.HoroscopeViewModel
import com.ziermax.horoscopapp.ui.luck.LuckFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 * Use the [LuckFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint

class PalmistryFragment : Fragment() {

	private var _binding: FragmentPalmistryBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
		return (binding.root)
	}
}