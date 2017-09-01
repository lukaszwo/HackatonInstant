package com.infullmobile.hackatoninstant.feature.remote

import retrofit2.http.GET
import rx.Single


/**
 * Created by andrii.kovalchuk on 01/09/2017.
 */
interface InstantApi {
    @GET("spreadsheets/d/e/2PACX-1vRcernEJZGZArrmNG_qtBrpbB2ipoMMcCIL4oDCPlGLfzCZnDAhN6tDLW5s_5e2-NnXs-0k3exHDMbF/pub?output=csv")
    fun getUser(): Single<String>
}