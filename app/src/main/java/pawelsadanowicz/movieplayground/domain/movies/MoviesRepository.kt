package pawelsadanowicz.movieplayground.domain.movies

import io.reactivex.Observable
import pawelsadanowicz.movieplayground.domain.movies.entity.Movie

interface MoviesRepository {

    fun getPopularMovies(page: Int): Observable<List<Movie>>
}
