package com.enightclub.app.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.enightclub.app.R

class ProfileFragment : Fragment() {

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_profile, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        viewModel.username.observe(viewLifecycleOwner) { name ->
            view.findViewById<android.widget.TextView>(R.id.profileName).text = name
        }
        viewModel.handle.observe(viewLifecycleOwner) { handle ->
            view.findViewById<android.widget.TextView>(R.id.profileUsername).text = handle
        }
        viewModel.eventsAttended.observe(viewLifecycleOwner) { count ->
            view.findViewById<android.widget.TextView>(R.id.eventsStat).text = "$count"
        }
        viewModel.followers.observe(viewLifecycleOwner) { count ->
            view.findViewById<android.widget.TextView>(R.id.friendsStat).text = "${count}K"
        }
        viewModel.following.observe(viewLifecycleOwner) { count ->
            view.findViewById<android.widget.TextView>(R.id.reviewsStat).text = "$count"
        }
    }
}
