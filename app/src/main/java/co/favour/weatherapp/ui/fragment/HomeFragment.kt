package co.favour.weatherapp.ui.fragment

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import co.favour.weatherapp.R
import co.favour.weatherapp.databinding.FragmentHomeBinding
import co.favour.weatherapp.ui.state.WeatherReportUiState
import co.favour.weatherapp.ui.state.WeatherReportUiState.Loading
import co.favour.weatherapp.ui.state.WeatherReportUiState.Success
import co.favour.weatherapp.ui.viewmodel.WeatherVm
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val weatherReportViewModel by viewModels<WeatherVm>()

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    private var progressDialog: ProgressDialog? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return fragmentHomeBinding.root
    }


    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                weatherReportViewModel.weatherReportUiState.collectLatest {
                    observeWeatherState(it)
                }
            }
        }
    }

    private fun observeWeatherState(weatherReportUiState: WeatherReportUiState?) {
        when (weatherReportUiState) {
            is Success -> {
                dismissProgress()
//                usersFeedRecyclerViewAdapter.submitList(weatherReportUiState.userFeed)
            }
            is Loading -> {
                progressDialog = ProgressDialog.show(context,
                    getString(R.string.fetching_weather_report),
                    getString(R.string.please_wait))
            }
            is WeatherReportUiState.Error -> {
                requireActivity().onErrorMessage(title = getString(R.string.error),
                    throwable = weatherReportUiState.exception)
            }
            else -> {

            }
        }
    }


    private fun dismissProgress() {
        progressDialog?.dismiss()
        progressDialog = null
    }

    private fun Context.onErrorMessage(title: String, throwable: Throwable) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(throwable.localizedMessage)
            .setNegativeButton(android.R.string.cancel, null)
            .show()

    }

}