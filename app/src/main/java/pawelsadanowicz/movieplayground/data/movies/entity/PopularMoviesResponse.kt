package pawelsadanowicz.movieplayground.data.movies.entity

import com.fasterxml.jackson.annotation.JsonProperty
import pawelsadanowicz.movieplayground.data.movies.entity.MovieData

data class PopularMoviesResponse(
        @JsonProperty("page") val page: Int,
        @JsonProperty("total_results") val totalResults: Int,
        @JsonProperty("total_pages") val totalPages: Int,
        @JsonProperty("results") val results: List<MovieData>
)
