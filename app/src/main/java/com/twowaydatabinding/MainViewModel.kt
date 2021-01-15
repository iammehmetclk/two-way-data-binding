package com.twowaydatabinding

import androidx.lifecycle.*

class MainViewModel : ViewModel() {

    private val _notes: MutableLiveData<List<Note>> = MutableLiveData(listOf())
    val notes: LiveData<List<Note>> = _notes
    val text: MutableLiveData<String> = MutableLiveData()

    fun insertNote() {
        var temp = ""
        text.value?.let { temp = it }
        if (temp.isNotBlank()) {
            _notes.postValue(_notes.value?.plus(Note(temp)))
            text.postValue("")
        }
    }
}