package pawelsadanowicz.movieplayground.util.resource

import android.content.Context

class AndroidResourceProvider(private val context: Context) : ResourceProvider {
    override fun getString(stringRes: Int): String = context.getString(stringRes)
}