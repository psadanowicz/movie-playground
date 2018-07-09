package pawelsadanowicz.movieplayground.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import pawelsadanowicz.movieplayground.util.rx.AppSchedulers
import pawelsadanowicz.movieplayground.util.rx.DefaultAppSchedulers
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    internal abstract fun bindContext(application: Application): Context

    @Module
    companion object {

        @Provides
        @Singleton
        @JvmStatic
        fun provideAppSchedulers(): AppSchedulers = DefaultAppSchedulers();
    }
}
