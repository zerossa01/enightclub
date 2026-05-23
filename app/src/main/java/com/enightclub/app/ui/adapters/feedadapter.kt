package com.enightclub.app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.enightclub.app.R
import com.enightclub.app.data.model.SocialFeedItem

class FeedAdapter(
    private var items: List<SocialFeedItem>
) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvUsername: TextView = view.findViewById(R.id.feedUserName)
        val tvAction: TextView = view.findViewById(R.id.feedAction)
        val tvTime: TextView = view.findViewById(R.id.feedTime)
        val tvLikes: TextView = view.findViewById(R.id.likeCount)
        val tvComments: TextView = view.findViewById(R.id.commentCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_social_feed, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val item = items[position]
        holder.tvUsername.text = item.userName
        holder.tvAction.text = item.action
        holder.tvTime.text = item.timeAgo
        holder.tvLikes.text = "${item.likes}"
        holder.tvComments.text = "${item.comments}"
    }

    override fun getItemCount(): Int = items.size

    fun updateData(newItems: List<SocialFeedItem>) {
        items = newItems
        notifyDataSetChanged()
    }
}
