package com.ziermax.horoscopapp.ui.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.ziermax.horoscopapp.R
import com.ziermax.horoscopapp.databinding.ActivityHoroscopeDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

	private lateinit var binding: ActivityHoroscopeDetailBinding
	private val horoscopeDetailViewMode: HoroscopeDetailViewMode by viewModels<HoroscopeDetailViewMode>()

	private val arg:HoroscopeDetailActivityArgs by navArgs<HoroscopeDetailActivityArgs>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
//		enableEdgeToEdge()
		setContentView(binding.root)
		initUI()
	}

	private fun initUI() {
		initUIState()
	}

	private	fun initUIState() {
		lifecycleScope.launch {
			repeatOnLifecycle(Lifecycle.State.STARTED) {
				horoscopeDetailViewMode.state.collect {horoscopeState ->
					when (horoscopeState) {
						HoroscopeDetailState.Loading -> loadingState()
						is HoroscopeDetailState.Error -> errorState()
						is HoroscopeDetailState.Success -> successState()
					}
				}
			}
		}
	}

	private fun loadingState() {
		binding.pbHoroscopeDescriptionDetail.isVisible = true
	}

	private fun errorState() {

	}

	private fun successState() {

	}
}
/*		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
			val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
			insets
		}*/