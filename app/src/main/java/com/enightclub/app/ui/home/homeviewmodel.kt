package com.enightclub.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enightclub.app.data.model.Event
import com.enightclub.app.data.model.Venue
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _featuredEvents = MutableLiveData<List<Event>>()
    val featuredEvents: LiveData<List<Event>> = _featuredEvents

    private val _trendingEvents = MutableLiveData<List<Event>>()
    val trendingEvents: LiveData<List<Event>> = _trendingEvents

    private val _nearbyVenues = MutableLiveData<List<Venue>>()
    val nearbyVenues: LiveData<List<Venue>> = _nearbyVenues

    private val _greeting = MutableLiveData<String>()
    val greeting: LiveData<String> = _greeting

    init {
        _greeting.value = getGreeting()
        loadFeaturedEvents()
        loadTrendingEvents()
        loadNearbyVenues()
    }

    private fun getGreeting(): String {
        val hour = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY)
        return when {
            hour >= 5 && hour < 12 -> "Good Morning ✨"
            hour >= 12 && hour < 17 -> "Good Afternoon 🌆"
            hour >= 17 && hour < 21 -> "Good Evening 🌃"
            else -> "Ready to party? 🎉"
        }
    }

    private fun loadFeaturedEvents() {
        _featuredEvents.value = listOf(
            Event(
                id = "1",
                name = "Neon Nights Festival",
                venue = "The Underground Lounge",
                dj = "DJ Lumina",
                date = "May 24, 2025",
                dayOfWeek = "FRI",
                dayNumber = "24",
                time = "10PM - 4AM",
                price = "$35",
                isFeatured = true,
                attendees = 342,
                distance = "0.8 mi",
                genre = "EDM"
            ),
            Event(
                id = "2",
                name = "Midnight Mirage",
                venue = "Velvet Sky Rooftop",
                dj = "DJ Aurora",
                date = "May 25, 2025",
                dayOfWeek = "SAT",
                dayNumber = "25",
                time = "11PM - 5AM",
                price = "$50",
                isFeatured = true,
                attendees = 528,
                distance = "1.2 mi",
                genre = "House"
            ),
            Event(
                id = "3",
                name = "Purple Haze Experience",
                venue = "Synthwave Arena",
                dj = "MC Prism",
                date = "May 26, 2025",
                dayOfWeek = "SUN",
                dayNumber = "26",
                time = "9PM - 3AM",
                price = "$25",
                isFeatured = true,
                attendees = 215,
                distance = "2.1 mi",
                genre = "Techno"
            )
        )
    }

    private fun loadTrendingEvents() {
        _trendingEvents.value = listOf(
            Event(
                id = "4",
                name = "Electric Dreams",
                venue = "Club Nebula",
                dj = "DJ Electra",
                date = "May 24, 2025",
                dayOfWeek = "FRI",
                dayNumber = "24",
                time = "10PM - 4AM",
                price = "$40",
                isTrending = true,
                attendees = 673,
                distance = "0.5 mi",
                genre = "Electro"
            ),
            Event(
                id = "5",
                name = "Bass Cathedral",
                venue = "The Vault",
                dj = "SubZero",
                date = "May 25, 2025",
                dayOfWeek = "SAT",
                dayNumber = "25",
                time = "11PM - 6AM",
                price = "$45",
                isTrending = true,
                attendees = 891,
                distance = "1.8 mi",
                genre = "Drum & Bass"
            ),
            Event(
                id = "6",
                name = "Glow Up Saturdays",
                venue = "Prism Hall",
                dj = "DJ Cosmos",
                date = "May 25, 2025",
                dayOfWeek = "SAT",
                dayNumber = "25",
                time = "10PM - 5AM",
                price = "$30",
                isTrending = true,
                attendees = 445,
                distance = "0.3 mi",
                genre = "Pop Remix"
            ),
            Event(
                id = "7",
                name = "After Dark Sessions",
                venue = "Shadow Lounge",
                dj = "DJ Obsidian",
                date = "May 26, 2025",
                dayOfWeek = "SUN",
                dayNumber = "26",
                time = "10PM - 4AM",
                price = "$20",
                isTrending = true,
                attendees = 198,
                distance = "1.5 mi",
                genre = "Deep House"
            )
        )
    }

    private fun loadNearbyVenues() {
        _nearbyVenues.value = listOf(
            Venue(
                id = "v1",
                name = "The Underground Lounge",
                type = "Nightclub",
                genres = "EDM • Techno • House",
                rating = 4.8,
                reviewCount = 342,
                distance = "0.8 mi",
                isOpen = true,
                address = "123 Sunset Blvd, LA"
            ),
            Venue(
                id = "v2",
                name = "Velvet Sky Rooftop",
                type = "Rooftop Bar",
                genres = "Lounge • R&B • Hip Hop",
                rating = 4.6,
                reviewCount = 289,
                distance = "1.2 mi",
                isOpen = true,
                address = "456 Hollywood Blvd, LA"
            ),
            Venue(
                id = "v3",
                name = "Synthwave Arena",
                type = "Superclub",
                genres = "Techno • Trance • Psytrance",
                rating = 4.9,
                reviewCount = 567,
                distance = "2.1 mi",
                isOpen = true,
                address = "789 Downtown, LA"
            )
        )
    }
}
