package pawelsadanowicz.movieplayground.feature.dashboard.view.databinding

import android.databinding.BindingAdapter
import android.support.design.chip.Chip
import android.support.design.chip.ChipGroup

object GenresBindingAdapter {
    @JvmStatic
    @BindingAdapter("genres")
    fun displayGenres(chipGroup: ChipGroup, genres: List<String>) {
        genres.forEach {
            val genre = Chip(chipGroup.context)
            genre.text = it
            chipGroup.addView(genre)
        }
    }
}
