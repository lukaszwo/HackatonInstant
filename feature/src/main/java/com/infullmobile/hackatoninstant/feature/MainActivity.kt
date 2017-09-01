package com.infullmobile.hackatoninstant.feature

import android.app.Activity
import android.os.Bundle
import rx.android.schedulers.AndroidSchedulers

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InstantApplication.instantApi.getUser().
                observeOn(AndroidSchedulers.mainThread())
                .subscribe({ csvText: String? -> processCsvResponse(csvText) },
                           { t: Throwable? -> processCsvResponse(t?.message) })

    }

    private fun processCsvResponse(csvText: String?) {
//        textView.text = csvText
    }

}
