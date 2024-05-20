package com.ziermax.horoscopapp.ui.horoscope

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ziermax.horoscopapp.databinding.FragmentHoroscopeBinding
import com.ziermax.horoscopapp.domain.model.HoroscopeInfo
import com.ziermax.horoscopapp.domain.model.HoroscopeModel
import com.ziermax.horoscopapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [HoroscopeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint

class HoroscopeFragment : Fragment() {

	private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
	private lateinit var horoscopeAdapter: HoroscopeAdapter

	private var _binding: FragmentHoroscopeBinding? = null
	private val binding get() = _binding!!

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initUi()
	}

	private fun initUi() {
		initList()
		initUiState()
	}

	private fun initList() {
		horoscopeAdapter = HoroscopeAdapter() { onItemSelected(it) }
		binding.rvHoroscopeFrag.apply {
			layoutManager = GridLayoutManager(context, 2)
			adapter = horoscopeAdapter
		}
	}

	private fun onItemSelected(horoscopeInfo: HoroscopeInfo) {
		val type: HoroscopeModel = when (horoscopeInfo) {
			HoroscopeInfo.Aquarius -> HoroscopeModel.Aquarius
			HoroscopeInfo.Aries -> HoroscopeModel.Aries
			HoroscopeInfo.Cancer -> HoroscopeModel.Cancer
			HoroscopeInfo.Capricorn -> HoroscopeModel.Capricorn
			HoroscopeInfo.Geminis -> HoroscopeModel.Geminis
			HoroscopeInfo.Leo -> HoroscopeModel.Leo
			HoroscopeInfo.Libra -> HoroscopeModel.Libra
			HoroscopeInfo.Pisces -> HoroscopeModel.Pisces
			HoroscopeInfo.Sagittarius -> HoroscopeModel.Sagittarius
			HoroscopeInfo.Scorpio -> HoroscopeModel.Scorpio
			HoroscopeInfo.Taurus -> HoroscopeModel.Taurus
			HoroscopeInfo.Virgo -> HoroscopeModel.Virgo
		}
		findNavController().navigate(
			HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(type)
		)
	}

	private fun initUiState() {
		lifecycleScope.launch {
			repeatOnLifecycle(Lifecycle.State.STARTED) {
				horoscopeViewModel.horoscope.collect { horoscopeList: List<HoroscopeInfo> ->
					horoscopeAdapter.updateList(horoscopeList)
				}
			}
		}
	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
		return (binding.root)
	}
}