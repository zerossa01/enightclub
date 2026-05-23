package com.enightclub.app.ui.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enightclub.app.data.model.Event

class EventsViewModel : ViewModel() {

    private val _events = MutableLiveData<List<Event>>()
    val events: LiveData<List<Event>> = _events

    private val _filteredEvents = MutableLiveData<List<Event>>()
    val filteredEvents: LiveData<List<Event>> = _filteredEvents

    private val _selectedFilter = MutableLiveData<String>()
    val selectedFilter: LiveData<String> = _selectedFilter

    init {
        _selectedFilter.value = "All"
        loadEvents()
    }

    private fun loadEvents() {
        val allEvents = listOf(
            Event(
                id = "e1",
                name = "Neon Nights Festival",
                venue = "The Underground Lounge",
                dj = "DJ Lumina",
                date = "May 24, 2025",
                dayOfWeek = "FRI",
                dayNumber = "24",
                time = "10PM - 4AM",
                price = "$35",
                attendees = 342,
                distance = "0.8 mi",
                genre = "EDM"
            ),
            Event(
                id = "e2",
                name = "Midnight Mirage",
                venue = "Velvet Sky Rooftop",
                dj = "DJ Aurora",
                date = "May 25, 2025",
                dayOfWeek = "SAT",
                dayNumber = "25",
                time = "11PM - 5AM",
                price = "$50",
                attendees = 528,
                distance = "1.2 mi",
                genre = "House"
            ),
            Event(
                id = "e3",
                name = "Electric Dreams",
                venue = "Club Nebula",
                dj = "DJ Electra",
                date = "May 24, 2025",
                dayOfWeek = "FRI",
                dayNumber = "24",
                time = "10PM - 4AM",
                price = "$40",
                attendees = 673,
                distance = "0.5 mi",
                genre = "Electro"
            ),
            Event(
                id = "e4",
                name = "Bass Cathedral",
                venue = "The Vault",
                dj = "SubZero",
                date = "May 25, 2025",
                dayOfWeek = "SAT",
                dayNumber = "25",
                time = "11PM - 6AM",
                price = "$45",
                attendees = 891,
                distance = "1.8 mi",
                genre = "Drum & Bass"
            ),
            Event(
                id = "e5",
                name = "Purple Haze Experience",
                venue = "Synthwave Arena",
                dj = "MC Prism",
                date = "May 26, 2025",
                dayOfWeek = "SUN",
                dayNumber = "26",
                time = "9PM - 3AM",
                price = "$25",
                attendees = 215,
                distance = "2.1 mi",
                genre = "Techno"
            ),
            Event(
                id = "e6",
                name = "Glow Up Saturdays",
                venue = "Prism Hall",
                dj = "DJ Cosmos",
                date = "May 25, 2025",
                dayOfWeek = "SAT",
                dayNumber = "25",
                time = "10PM - 5AM",
                price = "$30",
                attendees = 445,
                distance = "0.3 mi",
                genre = "Pop Remix"
            ),
            Event(
                id = "e7",
                name = "After Dark Sessions",
                venue = "Shadow Lounge",
                dj = "DJ Obsidian",
                date = "May 26, 2025",
                dayOfWeek = "SUN",
                dayNumber = "26",
                time = "10PM - 4AM",
                price = "$20",
                attendees = 198,
                distance = "1.5 mi",
                genre = "Deep House"
            ),
            Event(
                id = "e8",
                name = "Starfall Soirée",
                venue = "Celestial Ballroom",
                dj = "DJ Orion",
                date = "May 31, 2025",
                dayOfWeek = "FRI",
                dayNumber = "31",
                time = "10PM - 5AM",
                price = "$55",
                isFree = false,
                attendees = 720,
                distance = "3.2 mi",
                genre = "Progressive House"
            ),
            Event(
                id = "e9",
                name = "Free Flow Fridays",
                venue = "The Underground Lounge",
                dj = "DJ Ripple",
                date = "May 30, 2025",
                dayOfWeek = "FRI",
                dayNumber = "30",
                time = "9PM - 2AM",
                price = "FREE",
                isFree = true,
                attendees = 156,
                distance = "0.8 mi",
                genre = "R&B"
            ),
            Event(
                id = "e10",
                name = "Cyan Pulse Rave",
                venue = "Oceanic Pavilion",
                dj = "DJ Waveform",
                date = "June 7, 2025",
                dayOfWeek = "SAT",
                dayNumber = "07",
                time = "10PM - 6AM",
                price = "$60",
                attendees = 1200,
                distance = "5.4 mi",
                genre = "Trance"
            )
        )

        _events.value = allEvents
        _filteredEvents.value = allEvents
    }

    fun setFilter(filter: String) {
        _selectedFilter.value = filter
        val currentEvents = _events.value ?: emptyList()

        _filteredEvents.value = when (filter) {
            "Today" -> currentEvents.filter { it.dayNumber == "24" }
            "This Week" -> currentEvents.take(7)
            "This Month" -> currentEvents
            else -> currentEvents
        }
    }
}
