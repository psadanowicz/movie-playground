package pawelsadanowicz.movieplayground.util.resource

interface ResourceProvider {
    fun getString(stringRes: Int): String
}
