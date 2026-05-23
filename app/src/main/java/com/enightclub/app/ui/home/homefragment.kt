package com.enightclub.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.enightclub.app.R
import com.enightclub.app.data.model.Event
import com.enightclub.app.data.model.Venue
import com.enightclub.app.ui.adapters.EventAdapter
import com.enightclub.app.ui.adapters.VenueAdapter

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var featuredAdapter: EventAdapter
    private lateinit var trendingAdapter: EventAdapter
    private lateinit var nearbyAdapter: VenueAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        setupAdapters(view)
        observeViewModel(view)
    }

    private fun setupAdapters(view: View) {
        featuredAdapter = EventAdapter(emptyList())
        trendingAdapter = EventAdapter(emptyList())
        nearbyAdapter = VenueAdapter(emptyList())

        view.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.featuredEventsRecycler).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = featuredAdapter
        }
        view.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.trendingEventsRecycler).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = trendingAdapter
        }
        view.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.nearbyVenuesRecycler).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = nearbyAdapter
        }
    }

    private fun observeViewModel(view: View) {
        viewModel.greeting.observe(viewLifecycleOwner) { text ->
            view.findViewById<android.widget.TextView>(R.id.greetingText).text = text
        }
        viewModel.featuredEvents.observe(viewLifecycleOwner) { events ->
            featuredAdapter.updateData(events)
        }
        viewModel.trendingEvents.observe(viewLifecycleOwner) { events ->
            trendingAdapter.updateData(events)
        }
        viewModel.nearbyVenues.observe(viewLifecycleOwner) { venues ->
            nearbyAdapter.updateData(venues)
        }
    }
}
