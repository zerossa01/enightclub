package com.enightclub.app.ui.social

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.enightclub.app.R
import com.enightclub.app.ui.adapters.FeedAdapter
import com.enightclub.app.ui.adapters.StoryAdapter

class SocialFragment : Fragment() {

    private lateinit var viewModel: SocialViewModel
    private lateinit var storyAdapter: StoryAdapter
    private lateinit var feedAdapter: FeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_social, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[SocialViewModel::class.java]

        storyAdapter = StoryAdapter(emptyList())
        view.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.storiesRecycler).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = storyAdapter
        }

        feedAdapter = FeedAdapter(emptyList())
        view.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.feedRecycler).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = feedAdapter
        }

        viewModel.stories.observe(viewLifecycleOwner) { stories ->
            storyAdapter.updateData(stories)
        }
        viewModel.feedItems.observe(viewLifecycleOwner) { items ->
            feedAdapter.updateData(items)
        }
    }
}
