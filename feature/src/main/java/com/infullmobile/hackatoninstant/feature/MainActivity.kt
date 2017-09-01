package com.infullmobile.hackatoninstant.feature

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import rx.android.schedulers.AndroidSchedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InstantApplication.instantApi.getUser().
                observeOn(AndroidSchedulers.mainThread())
                .subscribe({ csvText: String? -> processCsvResponse(csvText) },
                           { t: Throwable? -> processCsvResponse(t?.message) })

    }

    private fun processCsvResponse(csvText: String?) {
        textView.text = csvText
    }

}
