package com.enightclub.app.ui.social

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enightclub.app.data.model.SocialFeedItem
import com.enightclub.app.data.model.Story

class SocialViewModel : ViewModel() {

    private val _stories = MutableLiveData<List<Story>>()
    val stories: LiveData<List<Story>> = _stories

    private val _feedItems = MutableLiveData<List<SocialFeedItem>>()
    val feedItems: LiveData<List<SocialFeedItem>> = _feedItems

    private val _onlineFriendsCount = MutableLiveData<Int>()
    val onlineFriendsCount: LiveData<Int> = _onlineFriendsCount

    init {
        loadStories()
        loadFeed()
    }

    private fun loadStories() {
        _stories.value = listOf(
            Story(
                id = "own",
                username = "Your Story",
                isOwnStory = true
            ),
            Story(
                id = "s1",
                username = "jessica",
                isOnline = true
            ),
            Story(
                id = "s2",
                username = "marcus_dj",
                isOnline = true
            ),
            Story(
                id = "s3",
                username = "neon.sarah"
            ),
            Story(
                id = "s4",
                username = "party.mike",
                isOnline = true
            ),
            Story(
                id = "s5",
                username = "luna.vibes"
            ),
            Story(
                id = "s6",
                username = "tech.house"
            )
        )
        _onlineFriendsCount.value = 12
    }

    private fun loadFeed() {
        _feedItems.value = listOf(
            SocialFeedItem(
                id = "f1",
                userName = "Jessica Chen",
                action = "is attending Neon Nights Festival",
                targetEvent = "Neon Nights Festival",
                timeAgo = "2h ago",
                likes = 24,
                comments = 8
            ),
            SocialFeedItem(
                id = "f2",
                userName = "Marcus Williams",
                action = "is going to Bass Cathedral tonight",
                targetEvent = "Bass Cathedral",
                timeAgo = "4h ago",
                likes = 56,
                comments = 12,
                isLiked = true
            ),
            SocialFeedItem(
                id = "f3",
                userName = "Sarah Neon",
                action = "checked in at Velvet Sky Rooftop",
                targetEvent = "Velvet Sky Rooftop",
                timeAgo = "5h ago",
                likes = 18,
                comments = 3
            ),
            SocialFeedItem(
                id = "f4",
                userName = "Mike Rivera",
                action = "shared Midnight Mirage event",
                targetEvent = "Midnight Mirage",
                timeAgo = "6h ago",
                likes = 42,
                comments = 7
            ),
            SocialFeedItem(
                id = "f5",
                userName = "Luna Garcia",
                action = "added a new review for Synthwave Arena",
                targetEvent = "Synthwave Arena",
                timeAgo = "8h ago",
                likes = 31,
                comments = 5
            ),
            SocialFeedItem(
                id = "f6",
                userName = "Tech House",
                action = "is attending Cyan Pulse Rave",
                targetEvent = "Cyan Pulse Rave",
                timeAgo = "12h ago",
                likes = 67,
                comments = 15
            ),
            SocialFeedItem(
                id = "f7",
                userName = "DJ Obsidian",
                action = "posted a new set from Shadow Lounge",
                targetEvent = "Shadow Lounge",
                timeAgo = "1d ago",
                likes = 128,
                comments = 34,
                isLiked = true
            )
        )
    }
}
