package co.favour.weatherapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.favour.weatherapp.data.Constants.DEFAULT_COUNTRY
import co.favour.weatherapp.data.Constants.METRIC
import co.favour.weatherapp.data.source.repository.WeatherRepository
import co.favour.weatherapp.ui.model.toWeatherReport
import co.favour.weatherapp.ui.state.WeatherReportUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherVm @Inject constructor(
    private val weatherRepository: WeatherRepository,
) : ViewModel() {

    private val _weatherReportUiState =
        MutableStateFlow<WeatherReportUiState>(WeatherReportUiState.Loading)
    val weatherReportUiState: StateFlow<WeatherReportUiState> = _weatherReportUiState

    init {
        fetchWeatherReport(metric = METRIC, cityOrCountry = DEFAULT_COUNTRY)
        observeWeatherReport()
    }

    private fun fetchWeatherReport(cityOrCountry: String, metric: String) {
        _weatherReportUiState.value = WeatherReportUiState.Loading
        viewModelScope.launch {

            try {
                weatherRepository.updateWeatherByCountryandMetric(metric, cityOrCountry)
            } catch (e: Throwable) {
                _weatherReportUiState.value = WeatherReportUiState.Error(e)
            }
        }
    }

    private fun observeWeatherReport() {
        viewModelScope.launch {
            weatherRepository.observeWeather().map {
                it.map {
                    it.toWeatherReport()
                }.apply {
                    _weatherReportUiState.value = WeatherReportUiState.Success(this)
                }
            }.launchIn(viewModelScope)
        }

    }
}

