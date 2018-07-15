package pawelsadanowicz.movieplayground.data.movies.service

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.doThrow
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Test
import pawelsadanowicz.movieplayground.data.movies.MovieDataMockHelper
import pawelsadanowicz.movieplayground.data.movies.entity.MovieData
import pawelsadanowicz.movieplayground.data.movies.entity.PopularMoviesResponse
import java.io.IOException

class MoviesServiceTest {

    @Test
    fun shouldReturnAllPopularMovies() {
        val movieData = MovieDataMockHelper.getMovieData()
        val response = mock<PopularMoviesResponse> {
            on { results } doReturn arrayListOf(movieData)
        }
        val service = mock<MoviesService> {
            on { getPopularMovies(any()) } doReturn Observable.just(response)
        }

        val observer = TestObserver<PopularMoviesResponse>()
        service.getPopularMovies(0).subscribe(observer)
        observer.assertComplete()
        observer.assertNoErrors()
        observer.assertResult(response)
        verify(service, times(1)).getPopularMovies(0)
    }

    @Test
    fun shouldReturnErrorForPopularMovies() {
        val service = mock<MoviesService> {
            on { getPopularMovies(any()) } doReturn Observable.error(IOException())
        }

        val observer = TestObserver<PopularMoviesResponse>()
        service.getPopularMovies(0).subscribe(observer)
        observer.assertError(IOException::class.java)
        observer.assertNotComplete()
        verify(service, times(1)).getPopularMovies(0)
    }

    @Test
    fun shouldProperlyReturnPopularMoviesForNextPage() {
        val service = mock<MoviesService> {
            on { getPopularMovies(any()) } doReturn Observable.just(MovieDataMockHelper.getPopularMoviesResponse())
        }

        val observer = TestObserver<PopularMoviesResponse>()
        service.getPopularMovies(0).subscribe()
        service.getPopularMovies(1).subscribe(observer)
        observer.assertComplete()
        observer.assertNoErrors()
        observer.assertResult(MovieDataMockHelper.getPopularMoviesResponse())
        verify(service, times(2)).getPopularMovies(any())
    }
}
