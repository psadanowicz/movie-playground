package pawelsadanowicz.movieplayground.domain.movies.entity

data class Movie(
        val id: String,
        val title: String,
        val overview: String,
        val posterPath: String,
        val genreIds: List<String>
)
