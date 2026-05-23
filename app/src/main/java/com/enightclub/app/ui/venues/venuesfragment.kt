package com.enightclub.app.ui.venues

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.enightclub.app.R
import com.enightclub.app.ui.adapters.VenueAdapter

class VenuesFragment : Fragment() {

    private lateinit var viewModel: VenuesViewModel
    private lateinit var adapter: VenueAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_venues, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[VenuesViewModel::class.java]

        adapter = VenueAdapter(emptyList())
        view.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.venuesRecycler).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@VenuesFragment.adapter
        }

        viewModel.venues.observe(viewLifecycleOwner) { venues ->
            adapter.updateData(venues)
        }
    }
}
