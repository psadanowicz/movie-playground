package pawelsadanowicz.movieplayground.domain.di

import dagger.Module
import dagger.Provides
import pawelsadanowicz.movieplayground.domain.movies.MoviesRepository
import pawelsadanowicz.movieplayground.domain.movies.usecase.GetPopularMoviesUseCase
import pawelsadanowicz.movieplayground.util.rx.AppSchedulers
import javax.inject.Singleton

@Module
object DomainModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideGetPopularMoviesUseCase(appSchedulers: AppSchedulers, moviesRepository: MoviesRepository): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCase(appSchedulers, moviesRepository)
    }

}
