package pawelsadanowicz.movieplayground.domain.movies.usecase

import io.reactivex.Observable
import pawelsadanowicz.movieplayground.domain.movies.MoviesRepository
import pawelsadanowicz.movieplayground.domain.movies.entity.Movie
import pawelsadanowicz.movieplayground.domain.util.DefaultUseCase
import pawelsadanowicz.movieplayground.util.rx.AppSchedulers

class GetPopularMoviesUseCase(appSchedulers: AppSchedulers, private val moviesRepository: MoviesRepository) : DefaultUseCase<Int, List<Movie>>(appSchedulers) {
    override fun run(params: Int): Observable<List<Movie>> {
        return moviesRepository.getPopularMovies(params)
    }
}
