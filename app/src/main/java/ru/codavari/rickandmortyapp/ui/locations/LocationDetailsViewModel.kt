package ru.codavari.rickandmortyapp.ui.locations

import androidx.lifecycle.*
import ru.codavari.rickandmortyapp.base.BaseViewModel
import ru.codavari.rickandmortyapp.data.Location
import ru.codavari.rickandmortyapp.usecase.GetCharacter
import ru.codavari.rickandmortyapp.usecase.GetLocation
import ru.codavari.rickandmortyapp.data.Character
import ru.codavari.rickandmortyapp.ui.MainNavigator
import javax.inject.Inject

class LocationDetailsViewModel @Inject constructor(

) : BaseViewModel<MainNavigator>() {

    private val _location = MutableLiveData<Location>()
    val location: LiveData<Location> = _location

    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> = _characters

}