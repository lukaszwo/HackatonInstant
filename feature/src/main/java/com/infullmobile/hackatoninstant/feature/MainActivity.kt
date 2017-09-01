package com.infullmobile.hackatoninstant.feature

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.infullmobile.hackatoninstant.feature.data.CsvToJsonConverter
import com.infullmobile.hackatoninstant.feature.data.IdeaEntity
import com.infullmobile.hackatoninstant.feature.data.IdeaEntity
import kotlinx.android.synthetic.main.list_layout.*
import rx.android.schedulers.AndroidSchedulers


class MainActivity : Activity() {

    private val csvToJsonConverter = CsvToJsonConverter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView
        InstantApplication.instantApi.getUser().
                observeOn(AndroidSchedulers.mainThread())
                .subscribe({ csvText: String? -> processCsvResponse(csvText) },
                           { t: Throwable? -> processCsvResponse(t?.message) })

    }

    private fun processCsvResponse(csvText: String?) {
        val json = csvToJsonConverter.csvToJson(csvText)
        val ideaEntity = Gson().fromJson<IdeaEntity>(json, IdeaEntity::class.java)
        Log.d("", "JSON = " + json)

        Log.d("", ideaEntity.toString())
        val listType = object : TypeToken<ArrayList<IdeaEntity>>() {}.type
        val ideaEntity = Gson().fromJson<List<IdeaEntity>>(json, listType)
        Log.d("", ideaEntity.toString())
    }

}