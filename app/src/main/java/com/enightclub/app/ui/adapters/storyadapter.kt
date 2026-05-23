package com.enightclub.app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.enightclub.app.R
import com.enightclub.app.data.model.Story

class StoryAdapter(
    private var stories: List<Story>
) : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.storyUsername)
        val ivAdd: View = view.findViewById(R.id.addStoryIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_social_story, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = stories[position]
        holder.tvName.text = story.username
        holder.ivAdd.visibility = if (story.isOwnStory) View.VISIBLE else View.GONE
    }

    override fun getItemCount(): Int = stories.size

    fun updateData(newStories: List<Story>) {
        stories = newStories
        notifyDataSetChanged()
    }
}
