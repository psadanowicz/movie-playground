package pawelsadanowicz.movieplayground

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import pawelsadanowicz.movieplayground.di.DaggerAppComponent
import timber.log.Timber

class BaseApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        initTimber();
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
                .builder()
                .application(this)
                .build()
    }

    fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
