package co.tractionapps.weatherapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.tractionapps.weatherapp.data.Constants.DEFAULT_COUNTRY
import co.tractionapps.weatherapp.data.Constants.METRIC
import co.tractionapps.weatherapp.data.Constants.SECONDS_IN_A_DAY
import co.tractionapps.weatherapp.data.source.repository.WeatherRepository
import co.tractionapps.weatherapp.ui.model.toWeatherReport
import co.tractionapps.weatherapp.ui.state.WeatherReportUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherVm  @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _weatherReportUiState = MutableStateFlow<WeatherReportUiState>(WeatherReportUiState.Loading)
    val weatherReportUiState: StateFlow<WeatherReportUiState> = _weatherReportUiState

    init {
        fetchWeatherReport(metric = METRIC, cityOrCountry =  DEFAULT_COUNTRY)
        observeWeatherReport()
    }

    private fun fetchWeatherReport(cityOrCountry: String, metric:String) {
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

