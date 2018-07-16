package pawelsadanowicz.movieplayground.feature.dashboard.view.databinding

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import pawelsadanowicz.movieplayground.domain.movies.entity.Movie
import pawelsadanowicz.movieplayground.feature.dashboard.view.adapter.DashboardRecyclerViewAdapter
import pawelsadanowicz.movieplayground.feature.dashboard.view.viewmodel.mapper.MovieViewModelMapper

object MoviesBindingAdapter {
    @JvmStatic
    @BindingAdapter(value = ["adapter", "items"], requireAll = true)
    fun setMovies(recyclerView: RecyclerView, adapter: DashboardRecyclerViewAdapter, movies: List<Movie>?) {
        if (movies != null) {
            adapter.setViewModels(MovieViewModelMapper.map(movies))
        }
    }

    @JvmStatic
    @BindingAdapter("recyclerViewAdapter")
    fun setAdapter(recyclerView: RecyclerView, adapter: DashboardRecyclerViewAdapter) {
        recyclerView.adapter = adapter
    }
}
