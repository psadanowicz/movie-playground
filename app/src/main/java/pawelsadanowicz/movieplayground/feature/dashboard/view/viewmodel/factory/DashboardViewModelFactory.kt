package pawelsadanowicz.movieplayground.feature.dashboard.view.viewmodel.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import pawelsadanowicz.movieplayground.domain.movies.usecase.GetPopularMoviesUseCase
import pawelsadanowicz.movieplayground.feature.dashboard.view.viewmodel.DashboardViewModel
import pawelsadanowicz.movieplayground.util.error.ErrorProvider

class DashboardViewModelFactory(private val popularMoviesUseCase: GetPopularMoviesUseCase,
                                private val errorProvider: ErrorProvider) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
            return DashboardViewModel(popularMoviesUseCase, errorProvider) as T
        } else {
            throw IllegalArgumentException("Wrong view model")
        }
    }
}
