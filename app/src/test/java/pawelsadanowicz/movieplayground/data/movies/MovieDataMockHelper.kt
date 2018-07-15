package pawelsadanowicz.movieplayground.data.movies

import pawelsadanowicz.movieplayground.data.movies.entity.MovieData
import pawelsadanowicz.movieplayground.data.movies.entity.PopularMoviesResponse

class MovieDataMockHelper {

    companion object {

        @JvmStatic
        fun getMovieData() = MovieData("1", "Title", "Overview", "https://path.poster.com/path.png", arrayListOf("horror", "fantasy"))

        @JvmStatic
        fun getMoviesData() = arrayListOf(getMovieData())

        @JvmStatic
        fun getPopularMoviesResponse() = PopularMoviesResponse(0, 1, 2, getMoviesData())
    }
}
