package com.infullmobile.hackatoninstant.feature

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson
import com.infullmobile.hackatoninstant.feature.data.CsvToJsonConverter
import com.infullmobile.hackatoninstant.feature.data.IdeaEntity
import rx.android.schedulers.AndroidSchedulers

class MainActivity : Activity() {

    private val csvToJsonConverter = CsvToJsonConverter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InstantApplication.instantApi.getUser().
                observeOn(AndroidSchedulers.mainThread())
                .subscribe({ csvText: String? -> processCsvResponse(csvText) },
                           { t: Throwable? -> processCsvResponse(t?.message) })

    }

    private fun processCsvResponse(csvText: String?) {
        val json = csvToJsonConverter.csvToJson(csvText)
        val ideaEntity = Gson().fromJson<IdeaEntity>(json, IdeaEntity::class.java)

        Log.d("", ideaEntity.toString())
    }

}
