package com.enightclub.app.ui.venues

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enightclub.app.data.model.Venue

class VenuesViewModel : ViewModel() {

    private val _venues = MutableLiveData<List<Venue>>()
    val venues: LiveData<List<Venue>> = _venues

    private val _filteredVenues = MutableLiveData<List<Venue>>()
    val filteredVenues: LiveData<List<Venue>> = _filteredVenues

    init {
        loadVenues()
    }

    private fun loadVenues() {
        val allVenues = listOf(
            Venue(
                id = "v1",
                name = "The Underground Lounge",
                type = "Nightclub",
                genres = "EDM • Techno • House",
                rating = 4.8,
                reviewCount = 342,
                distance = "0.8 mi",
                isOpen = true,
                address = "123 Sunset Blvd, Los Angeles",
                priceLevel = 2,
                phone = "(310) 555-0123"
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
                address = "456 Hollywood Blvd, Los Angeles",
                priceLevel = 3,
                phone = "(323) 555-0456"
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
                address = "789 Downtown, Los Angeles",
                priceLevel = 2,
                phone = "(213) 555-0789"
            ),
            Venue(
                id = "v4",
                name = "Club Nebula",
                type = "Nightclub",
                genres = "Electro • Future Bass",
                rating = 4.5,
                reviewCount = 198,
                distance = "0.5 mi",
                isOpen = true,
                address = "321 Melrose Ave, Los Angeles",
                priceLevel = 2,
                phone = "(323) 555-0321"
            ),
            Venue(
                id = "v5",
                name = "The Vault",
                type = "Underground Club",
                genres = "Drum & Bass • Jungle",
                rating = 4.7,
                reviewCount = 423,
                distance = "1.8 mi",
                isOpen = false,
                address = "654 Warehouse District, LA",
                priceLevel = 1,
                phone = "(310) 555-0654"
            ),
            Venue(
                id = "v6",
                name = "Prism Hall",
                type = "Event Space",
                genres = "Pop • Remix • Top 40",
                rating = 4.3,
                reviewCount = 156,
                distance = "0.3 mi",
                isOpen = true,
                address = "987 Santa Monica Blvd, LA",
                priceLevel = 2,
                phone = "(310) 555-0987"
            ),
            Venue(
                id = "v7",
                name = "Shadow Lounge",
                type = "Speakeasy Bar",
                genres = "Deep House • Jazz • Lounge",
                rating = 4.8,
                reviewCount = 234,
                distance = "1.5 mi",
                isOpen = true,
                address = "147 Arts District, Los Angeles",
                priceLevel = 3,
                phone = "(213) 555-0147"
            ),
            Venue(
                id = "v8",
                name = "Celestial Ballroom",
                type = "Ballroom",
                genres = "Progressive House • Melodic",
                rating = 4.4,
                reviewCount = 89,
                distance = "3.2 mi",
                isOpen = false,
                address = "258 Beverly Blvd, Los Angeles",
                priceLevel = 3,
                phone = "(310) 555-0258"
            )
        )

        _venues.value = allVenues
        _filteredVenues.value = allVenues
    }

    fun setFilter(filter: String) {
        val currentVenues = _venues.value ?: emptyList()

        _filteredVenues.value = when (filter) {
            "Open Now" -> currentVenues.filter { it.isOpen }
            "Top Rated" -> currentVenues.sortedByDescending { it.rating }
            "Nearby" -> currentVenues.sortedBy { it.distance.toDoubleOrNull() ?: Double.MAX_VALUE }
            else -> currentVenues
        }
    }
}
