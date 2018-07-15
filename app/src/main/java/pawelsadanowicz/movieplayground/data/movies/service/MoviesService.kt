package pawelsadanowicz.movieplayground.data.movies.service

import io.reactivex.Observable
import pawelsadanowicz.movieplayground.data.movies.entity.PopularMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET("/movie/popular")
    fun getPopularMovies(@Query("page") page: Int): Observable<PopularMoviesResponse>
}
