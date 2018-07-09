package pawelsadanowicz.movieplayground.feature.splash.di

import dagger.Module
import dagger.Provides
import pawelsadanowicz.movieplayground.di.ActivityScope
import pawelsadanowicz.movieplayground.feature.splash.SplashActivity
import pawelsadanowicz.movieplayground.util.navigator.AndroidApplicationNavigator
import pawelsadanowicz.movieplayground.util.navigator.ApplicationNavigator

@Module
object SplashActivityModule {

    @Provides
    @ActivityScope
    @JvmStatic
    fun provideApplicationNavigator(activity: SplashActivity): ApplicationNavigator = AndroidApplicationNavigator(activity)
}
