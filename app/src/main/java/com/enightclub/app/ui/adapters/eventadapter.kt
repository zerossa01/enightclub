package com.enightclub.app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.enightclub.app.R
import com.enightclub.app.data.model.Event

class EventAdapter(
    private var events: List<Event>,
    private val onItemClick: ((Event) -> Unit)? = null
) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.eventName)
        val tvVenue: TextView = view.findViewById(R.id.eventVenue)
        val tvDj: TextView = view.findViewById(R.id.eventDj)
        val tvDateDay: TextView = view.findViewById(R.id.dateDay)
        val tvDateNumber: TextView = view.findViewById(R.id.dateNumber)
        val tvPrice: TextView = view.findViewById(R.id.priceBadge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event_card, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        holder.tvTitle.text = event.name
        holder.tvVenue.text = event.venue
        holder.tvDj.text = event.dj
        holder.tvDateDay.text = event.dayOfWeek
        holder.tvDateNumber.text = event.dayNumber
        holder.tvPrice.text = event.price
        holder.itemView.setOnClickListener { onItemClick?.invoke(event) }
    }

    override fun getItemCount(): Int = events.size

    fun updateData(newEvents: List<Event>) {
        events = newEvents
        notifyDataSetChanged()
    }
}
