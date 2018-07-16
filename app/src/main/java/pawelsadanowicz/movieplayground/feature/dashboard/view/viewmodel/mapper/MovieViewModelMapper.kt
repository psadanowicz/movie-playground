package pawelsadanowicz.movieplayground.feature.dashboard.view.viewmodel.mapper

import pawelsadanowicz.movieplayground.domain.movies.entity.Movie
import pawelsadanowicz.movieplayground.feature.dashboard.view.viewmodel.MovieViewModel

object MovieViewModelMapper {
    fun map(movies: List<Movie>): List<MovieViewModel> = movies.map(this::map)

    fun map(movie: Movie): MovieViewModel = MovieViewModel(movie)
}
