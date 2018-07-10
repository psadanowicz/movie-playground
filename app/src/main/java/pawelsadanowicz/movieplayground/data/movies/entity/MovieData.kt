package pawelsadanowicz.movieplayground.data.movies.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class MovieData(
        @JsonProperty("id") val id: String,
        @JsonProperty("title") val title: String,
        @JsonProperty("overview") val overview: String,
        @JsonProperty("poster_path") val posterPath: String,
        @JsonProperty("genre_ids") val genreIds: List<String>
)
