package pawelsadanowicz.movieplayground.util.databinding

import android.databinding.BindingAdapter
import android.support.v7.widget.AppCompatImageView
import com.bumptech.glide.Glide

object ImageViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("srcCompat")
    fun loadImage(imageView: AppCompatImageView, url: String) {
        Glide.with(imageView.context).load(url).into(imageView)
    }
}
