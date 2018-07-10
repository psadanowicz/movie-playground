package pawelsadanowicz.movieplayground.data.movies

import io.reactivex.Observable
import pawelsadanowicz.movieplayground.data.movies.mapper.MoviesMapper
import pawelsadanowicz.movieplayground.data.movies.service.MoviesService
import pawelsadanowicz.movieplayground.domain.movies.entity.Movie
import pawelsadanowicz.movieplayground.domain.movies.MoviesRepository

class MoviesRepositoryImpl(private val service: MoviesService) : MoviesRepository {
    override fun getPopularMovies(page: Int): Observable<List<Movie>> {
        return service.getPopularMovies(page)
                .map { response -> MoviesMapper.map(response.results) }
    }
}
