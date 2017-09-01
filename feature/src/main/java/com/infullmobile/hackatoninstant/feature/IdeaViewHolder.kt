package com.infullmobile.hackatoninstant.feature

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.infullmobile.hackatoninstant.feature.data.IdeaEntity
import com.infullmobile.hackatoninstant.feature.ui.bindView

class IdeaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val header: TextView by bindView(R.id.ideaHeader)
    private val ideaDescription: TextView by bindView(R.id.ideaDescription)
    private val teamPeople: TextView by bindView(R.id.teamPeople)
    private val teamLabel: TextView by bindView(R.id.teamLabel)


    fun bind(ideaEntity: IdeaEntity) {
        header.text = ideaEntity.idea
        ideaDescription.text = ideaEntity.idea

        val teamString = "${ideaEntity.teamAugustHackathon} ${ideaEntity.teamJulyHackathon} ${ideaEntity.teamJuneHackathon} ${ideaEntity.teamMayHackathon} ${ideaEntity.teamSeptemberHackathonCURRENT}"
        if (teamString.isBlank()) teamLabel.visibility = View.GONE
        else teamLabel.visibility = View.VISIBLE

        teamPeople.text = teamString
    }

}