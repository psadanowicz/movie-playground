package pawelsadanowicz.movieplayground.feature.dashboard.view.viewmodel

import android.databinding.ObservableField
import pawelsadanowicz.movieplayground.domain.movies.entity.Movie

class MovieViewModel(movie: Movie) {

    val id: String
    val title = ObservableField<String>()
    val overview = ObservableField<String>()
    val imageUrl = ObservableField<String>()
    val genres = ObservableField<List<String>>()

    init {
        id = movie.id
        title.set(movie.title)
        overview.set(movie.overview)
        imageUrl.set(movie.posterPath)
        genres.set(movie.genres)
    }
}
