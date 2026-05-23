package com.enightclub.app.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.enightclub.app.R
import com.enightclub.app.ui.adapters.EventAdapter

class EventsFragment : Fragment() {

    private lateinit var viewModel: EventsViewModel
    private lateinit var adapter: EventAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_events, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[EventsViewModel::class.java]

        adapter = EventAdapter(emptyList())
        view.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.eventsRecycler).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@EventsFragment.adapter
        }

        viewModel.events.observe(viewLifecycleOwner) { events ->
            adapter.updateData(events)
        }
    }
}
