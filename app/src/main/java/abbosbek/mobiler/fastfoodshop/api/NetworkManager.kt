package abbosbek.mobiler.fastfoodshop.api

import abbosbek.mobiler.fastfoodshop.MyApp
import abbosbek.mobiler.fastfoodshop.utils.Constants
import abbosbek.mobiler.fastfoodshop.utils.Constants.BASE_URL
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {
    var api : Api ?= null

    fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .build()
    }

    fun getOkHttpClient() : OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor.Builder(MyApp.app)
                .collector(ChuckerCollector(MyApp.app))
                .maxContentLength(250000L)
                .redactHeaders(emptySet())
                .alwaysReadResponseBody(false)
                .build())
            .build()
    }

    fun getApiInstance() : Api{
        if (api == null){
            api = getRetrofit().create(Api::class.java)
        }
        return api!!
    }
}