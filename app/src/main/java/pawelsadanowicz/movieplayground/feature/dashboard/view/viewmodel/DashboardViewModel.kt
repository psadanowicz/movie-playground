package pawelsadanowicz.movieplayground.feature.dashboard.view.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import pawelsadanowicz.movieplayground.domain.movies.entity.Movie
import pawelsadanowicz.movieplayground.domain.movies.usecase.GetPopularMoviesUseCase
import pawelsadanowicz.movieplayground.util.error.ErrorProvider
import timber.log.Timber

class DashboardViewModel(getPopularMoviesUseCase: GetPopularMoviesUseCase, errorProvider: ErrorProvider) : ViewModel() {

    private val movies = MutableLiveData<List<Movie>?>()
    private val error = MutableLiveData<String?>()

    init {
        getPopularMoviesUseCase.execute(1,
                onNext = {
                    movies.value = it
                },
                onError = {
                    Timber.e(it, "Error while loading popular movies")
                    error.value = errorProvider.provideUnknownErrorMessage()
                })
    }

    fun getMovies(): LiveData<List<Movie>?> = movies

    fun getError(): LiveData<String?> = error
}
