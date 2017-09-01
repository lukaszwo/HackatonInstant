package com.infullmobile.hackatoninstant.feature

import android.app.Application
import com.infullmobile.hackatoninstant.feature.remote.InstantApi
import com.infullmobile.hackatoninstant.feature.remote.ToStringConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import rx.schedulers.Schedulers


/**
 * Created by andrii.kovalchuk on 01/09/2017.
 */

class InstantApplication : Application() {
    // https://docs.google.com/spreadsheets/d/e/2PACX-1vRcernEJZGZArrmNG_qtBrpbB2ipoMMcCIL4oDCPlGLfzCZnDAhN6tDLW5s_5e2-NnXs-0k3exHDMbF/pub?output=csv
    companion object {
        lateinit var instantApi: InstantApi
    }

    private val BASE_URL = "https://docs.google.com/"

    override fun onCreate() {
        super.onCreate()


        val rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io())
        instantApi = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ToStringConverterFactory())
                .addCallAdapterFactory(rxAdapter)
                .build()
                .create(InstantApi::class.java)
    }
}
