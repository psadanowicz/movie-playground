package pawelsadanowicz.movieplayground.feature.dashboard.view.viewmodel.adapter

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.databinding.ObservableField
import pawelsadanowicz.movieplayground.domain.movies.entity.Movie
import pawelsadanowicz.movieplayground.feature.dashboard.view.viewmodel.DashboardViewModel

class DashboardAdapter(lifecycleOwner: LifecycleOwner, viewModel: DashboardViewModel) {

    val movies = ObservableField<List<Movie>>()
    val error = ObservableField<String?>()

    init {
        viewModel.getMovies().observe(lifecycleOwner, Observer { movies.set(it) })
        viewModel.getError().observe(lifecycleOwner, Observer { error.set(it) })
    }
}
