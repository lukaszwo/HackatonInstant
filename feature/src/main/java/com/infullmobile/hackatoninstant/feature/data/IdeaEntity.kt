package com.infullmobile.hackatoninstant.feature.data

import com.google.gson.annotations.SerializedName

data class IdeaEntity(

        @field:SerializedName("Team @ September Hackathon (CURRENT)")
        val teamSeptemberHackathonCURRENT: String? = null,

        @field:SerializedName("Idea")
        val idea: String,

        @field:SerializedName("Team @ July Hackathon")
        val teamJulyHackathon: String? = null,

        @field:SerializedName("Kal")
        val kal: String? = null,

        @field:SerializedName("Team @ June Hackathon")
        val teamJuneHackathon: String? = null,

        @field:SerializedName("Team @ August Hackathon")
        val teamAugustHackathon: String? = null,

        @field:SerializedName("Team @ May Hackathon")
        val teamMayHackathon: String? = null
)