package pawelsadanowicz.movieplayground.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import pawelsadanowicz.movieplayground.BaseApplication
import pawelsadanowicz.movieplayground.data.di.DataModule
import pawelsadanowicz.movieplayground.domain.di.DomainModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    AppModule::class,
    DataModule::class,
    DomainModule::class
])
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}
