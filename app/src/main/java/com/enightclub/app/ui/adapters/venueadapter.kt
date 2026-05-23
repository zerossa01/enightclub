package com.enightclub.app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.enightclub.app.R
import com.enightclub.app.data.model.Venue

class VenueAdapter(
    private var venues: List<Venue>,
    private val onItemClick: ((Venue) -> Unit)? = null
) : RecyclerView.Adapter<VenueAdapter.VenueViewHolder>() {

    class VenueViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.venueName)
        val tvType: TextView = view.findViewById(R.id.venueType)
        val tvRating: TextView = view.findViewById(R.id.ratingText)
        val tvDistance: TextView = view.findViewById(R.id.venueDistance)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_venue_card, parent, false)
        return VenueViewHolder(view)
    }

    override fun onBindViewHolder(holder: VenueViewHolder, position: Int) {
        val venue = venues[position]
        holder.tvName.text = venue.name
        holder.tvType.text = venue.genres
        holder.tvRating.text = venue.rating.toString()
        holder.tvDistance.text = venue.distance
        holder.itemView.setOnClickListener { onItemClick?.invoke(venue) }
    }

    override fun getItemCount(): Int = venues.size

    fun updateData(newVenues: List<Venue>) {
        venues = newVenues
        notifyDataSetChanged()
    }
}
