package pawelsadanowicz.movieplayground.data.util

import okhttp3.Interceptor
import okhttp3.Response
import pawelsadanowicz.movieplayground.data.DataConstants.API_TOKEN_QUERY_NAME

class ApiTokenInterceptor(private val token: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        val oldRequest = chain!!.request()
        val url = oldRequest.url().newBuilder()
                .addQueryParameter(API_TOKEN_QUERY_NAME, token)
                .build()
        val newRequest = chain.request().newBuilder()
                .url(url)
                .build()

        return chain.proceed(newRequest)
    }
}
