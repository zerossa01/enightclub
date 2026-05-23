package com.enightclub.app.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _username = MutableLiveData("Alex Rivera")
    val username: LiveData<String> = _username

    private val _handle = MutableLiveData("@alexnightlife")
    val handle: LiveData<String> = _handle

    private val _bio = MutableLiveData("Chasing beats & neon lights since 2019 🌙✨")
    val bio: LiveData<String> = _bio

    private val _eventsAttended = MutableLiveData(147)
    val eventsAttended: LiveData<Int> = _eventsAttended

    private val _followers = MutableLiveData(2840)
    val followers: LiveData<Int> = _followers

    private val _following = MutableLiveData(521)
    val following: LiveData<Int> = _following
}
