package pawelsadanowicz.movieplayground.data.di

import com.fasterxml.jackson.databind.ObjectMapper
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import pawelsadanowicz.movieplayground.BuildConfig
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
object DataModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideApiUrl(): HttpUrl = HttpUrl.parse(BuildConfig.API_URL)!!;

    @Provides
    @Singleton
    @JvmStatic
    fun provideObjectMapper(): ObjectMapper = ObjectMapper()

    @Provides
    @Singleton
    @JvmStatic
    fun provideJacksonConverterFactory(objectMapper: ObjectMapper): Converter.Factory = JacksonConverterFactory.create(objectMapper)

    @Provides
    @Singleton
    @JvmStatic
    fun provideRxJavaAdapter(): CallAdapter.Factory = RxJava2CallAdapterFactory.create();

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
}
