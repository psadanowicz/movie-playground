package pawelsadanowicz.movieplayground.data.di

import android.content.Context
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pawelsadanowicz.movieplayground.BuildConfig
import pawelsadanowicz.movieplayground.data.DataConstants
import pawelsadanowicz.movieplayground.data.movies.MoviesRepositoryImpl
import pawelsadanowicz.movieplayground.data.movies.service.MoviesService
import pawelsadanowicz.movieplayground.data.util.ApiTokenInterceptor
import pawelsadanowicz.movieplayground.data.util.CurlLoggingInterceptor
import pawelsadanowicz.movieplayground.domain.movies.MoviesRepository
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object DataModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideApiUrl(): HttpUrl = HttpUrl.parse(BuildConfig.API_URL)!!

    @Provides
    @Singleton
    @JvmStatic
    fun provideJacksonKotlinModule(): KotlinModule = KotlinModule()

    @Provides
    @Singleton
    @JvmStatic
    fun provideObjectMapper(kotlinModule: KotlinModule): ObjectMapper {
        val objectMapper = ObjectMapper()
        objectMapper.registerModule(kotlinModule)
        return objectMapper
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideJacksonConverterFactory(objectMapper: ObjectMapper): Converter.Factory = JacksonConverterFactory.create(objectMapper)

    @Provides
    @Singleton
    @JvmStatic
    fun provideRxJavaAdapter(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    @JvmStatic
    fun provideHttpCacheDir(context: Context): File = File(context.cacheDir, "HttpResponseCache")

    @Provides
    @Singleton
    @JvmStatic
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return loggingInterceptor
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideCurlLoggerInterceptor() = CurlLoggingInterceptor()

    @Provides
    @Singleton
    @JvmStatic
    fun provideCache(cacheDir: File) = Cache(cacheDir, DataConstants.HTTP_CACHE_SIZE)

    @Provides
    @Singleton
    @JvmStatic
    fun provideApiTokenInterceptor() = ApiTokenInterceptor(BuildConfig.API_KEY)

    @Provides
    @Singleton
    @JvmStatic
    fun provideOkHttpClient(cache: Cache, httpLoggingInterceptor: HttpLoggingInterceptor, curlLoggingInterceptor: CurlLoggingInterceptor,
                            apiTokenInterceptor: ApiTokenInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor) //todo disable for non-dev flavors
                .addInterceptor(curlLoggingInterceptor)
                .addInterceptor(apiTokenInterceptor)
                .writeTimeout(DataConstants.HTTP_WRITE_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(DataConstants.HTTP_READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .cache(cache)
                .build()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideRetrofit(
            httpUrl: HttpUrl,
            client: OkHttpClient,
            converterFactory: Converter.Factory,
            callAdapterFactory: CallAdapter.Factory
    ): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl(httpUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideMoviesService(retrofit: Retrofit): MoviesService = retrofit.create(MoviesService::class.java)

    @Provides
    @Singleton
    @JvmStatic
    fun provideMoviesRepository(service: MoviesService): MoviesRepository = MoviesRepositoryImpl(service)
}
