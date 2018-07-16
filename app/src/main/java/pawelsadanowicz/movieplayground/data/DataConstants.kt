package pawelsadanowicz.movieplayground.data

import java.util.concurrent.TimeUnit

object DataConstants {

    val HTTP_CACHE_SIZE = 1024L * 1024L * 10L
    val HTTP_WRITE_TIMEOUT_SECONDS = TimeUnit.MINUTES.toSeconds(5)
    val HTTP_READ_TIMEOUT_SECONDS = TimeUnit.MINUTES.toSeconds(5)
    val API_TOKEN_QUERY_NAME = "api_key"
}