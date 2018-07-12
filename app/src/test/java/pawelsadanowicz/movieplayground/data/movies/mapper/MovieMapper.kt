package pawelsadanowicz.movieplayground.data.movies.mapper

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import pawelsadanowicz.movieplayground.data.movies.entity.MovieData
import pawelsadanowicz.movieplayground.domain.movies.entity.Movie

class MovieMapper {

    @Test
    fun shouldProperlyCreateMovieObject() {
        val movieData = MovieData("1", "Title", "Something", "https://path.poster.com/path.png",
                arrayListOf("horror", "fantasy"))
        val expectedMovie = Movie("1", "Title", "Something", "https://path.poster.com/path.png",
                arrayListOf("horror", "fantasy"))

        assertThat(MoviesMapper.map(movieData)).isNotNull().isEqualTo(expectedMovie)
    }

    @Test
    fun shouldProperlyCreateMovies() {
        val movieData = MovieData("1", "Title", "Something", "https://path.poster.com/path.png",
                arrayListOf("horror", "fantasy"))
        val expectedMovie = Movie("1", "Title", "Something", "https://path.poster.com/path.png",
                arrayListOf("horror", "fantasy"))
        val moviesData = arrayListOf(movieData)
        val expectedMovies = arrayListOf(expectedMovie)

        assertThat(MoviesMapper.map(moviesData))
                .isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .isEqualTo(expectedMovies)
    }
}
