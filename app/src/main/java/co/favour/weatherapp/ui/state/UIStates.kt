package co.favour.weatherapp.ui.state

import co.favour.weatherapp.ui.model.WeatherReport


/**
 * UI state for the Posts screen
 */
sealed class WeatherReportUiState {
    data class Success(val weatherFeed: List<WeatherReport>) : WeatherReportUiState()
    data class Error(val exception: Throwable) : WeatherReportUiState()
    object Loading : WeatherReportUiState()
}

