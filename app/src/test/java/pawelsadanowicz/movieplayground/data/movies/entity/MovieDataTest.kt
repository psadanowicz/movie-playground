package pawelsadanowicz.movieplayground.data.movies.entity

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class MovieDataTest {

    @Test
    fun shouldHaveProperId() {
        val movieData = mock<MovieData> {
            on { id } doReturn "1"
        }

        assertThat(movieData.id)
                .isNotEmpty()
                .isEqualTo("1")
    }

    @Test
    fun shouldHaveProperOverview() {
        val movieData = mock<MovieData> {
            on { overview } doReturn "Something"
        }

        assertThat(movieData.overview)
                .isNotEmpty()
                .isEqualTo("Something")
    }

    @Test
    fun shouldHaveProperTitle() {
        val movieData = mock<MovieData> {
            on { title } doReturn "Title"
        }

        assertThat(movieData.title)
                .isNotEmpty()
                .isEqualTo("Title");
    }

    @Test
    fun shouldHaveProperPosterPath() {
        val movieData = mock<MovieData> {
            on { posterPath } doReturn "https://path.proper.com/path.png"
        }

        assertThat(movieData.posterPath)
                .isNotEmpty()
                .containsPattern("(https?:\\/\\/.*\\.(?:png|jpg))")
                .isEqualTo("https://path.proper.com/path.png")
    }

    @Test
    fun shouldHaveProper() {
        val movieData = mock<MovieData> {
            on { genreIds } doReturn arrayListOf("horror", "drama", "fantasy")
        }
        assertThat(movieData.genreIds)
                .isNotNull()
                .isNotEmpty()
                .hasSize(3)
                .isEqualTo(arrayListOf("horror", "drama", "fantasy"))
    }
}
