package pawelsadanowicz.movieplayground.data.movies.mapper

import pawelsadanowicz.movieplayground.data.movies.entity.MovieData
import pawelsadanowicz.movieplayground.domain.movies.entity.Movie

object MoviesMapper {

    @JvmStatic
    fun map(moviesData: List<MovieData>): List<Movie> {
        return moviesData.map { movieData -> map(movieData) }
    }

    @JvmStatic
    fun map(movieData: MovieData): Movie {
        return Movie(movieData.id, movieData.title, movieData.overview, movieData.posterPath, movieData.genreIds)
    }
}
