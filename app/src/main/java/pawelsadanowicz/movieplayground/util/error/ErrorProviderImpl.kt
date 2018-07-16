package pawelsadanowicz.movieplayground.util.error

import pawelsadanowicz.movieplayground.R
import pawelsadanowicz.movieplayground.util.resource.ResourceProvider

class ErrorProviderImpl(private val resourceProvider: ResourceProvider) : ErrorProvider {
    override fun provideUnknownErrorMessage(): String = resourceProvider.getString(R.string.unknown_error)
}
