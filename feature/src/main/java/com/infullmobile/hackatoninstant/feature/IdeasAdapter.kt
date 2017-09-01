package com.infullmobile.hackatoninstant.feature

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.infullmobile.hackatoninstant.feature.data.IdeaEntity


class IdeasAdapter(private val ideas: List<IdeaEntity>) : RecyclerView.Adapter<IdeaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): IdeaViewHolder {
        val context = parent?.getContext()
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val view = inflater.inflate(R.layout.single_item_layout, parent, false)
        return IdeaViewHolder(view)
    }

    override fun getItemCount() = ideas.size

    override fun onBindViewHolder(holder: IdeaViewHolder, position: Int) {
        val ideaEntity = ideas[position]
        holder.bind(ideaEntity)
    }
}