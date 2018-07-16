package pawelsadanowicz.movieplayground.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import pawelsadanowicz.movieplayground.util.error.ErrorProvider
import pawelsadanowicz.movieplayground.util.error.ErrorProviderImpl
import pawelsadanowicz.movieplayground.util.resource.AndroidResourceProvider
import pawelsadanowicz.movieplayground.util.resource.ResourceProvider
import pawelsadanowicz.movieplayground.util.rx.AppSchedulers
import pawelsadanowicz.movieplayground.util.rx.DefaultAppSchedulers
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @Module
    companion object {

        @Provides
        @Singleton
        @JvmStatic
        fun provideAppSchedulers(): AppSchedulers = DefaultAppSchedulers();

        @Provides
        @Singleton
        @JvmStatic
        fun provideResourceProvider(context: Context): ResourceProvider = AndroidResourceProvider(context)

        @Provides
        @Singleton
        @JvmStatic
        fun provideErrorProvider(resourceProvider: ResourceProvider): ErrorProvider = ErrorProviderImpl(resourceProvider)
    }
}
