package pawelsadanowicz.movieplayground.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pawelsadanowicz.movieplayground.feature.dashboard.DashboardActivity
import pawelsadanowicz.movieplayground.feature.dashboard.di.DashboardActivityModule
import pawelsadanowicz.movieplayground.feature.splash.SplashActivity
import pawelsadanowicz.movieplayground.feature.splash.di.SplashActivityModule

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun splashActivity(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [DashboardActivityModule::class])
    abstract fun dashboardActivity(): DashboardActivity
}
