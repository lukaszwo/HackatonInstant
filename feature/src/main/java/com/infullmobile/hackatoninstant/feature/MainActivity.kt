package com.infullmobile.hackatoninstant.feature

import android.app.Activity
import android.os.Bundle
import com.infullmobile.hackatoninstant.feature.data.CsvToJsonConverter
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
//        val ideaEntity = Gson().fromJson<List<IdeaEntityList>>(json, IdeaEntityList::class.java)

//        Log.d("", ideaEntity.toString())
    }

}
