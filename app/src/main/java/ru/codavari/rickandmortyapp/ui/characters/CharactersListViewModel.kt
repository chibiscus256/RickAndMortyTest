package ru.codavari.rickandmortyapp.ui.characters

import androidx.lifecycle.*
import ru.codavari.rickandmortyapp.ui.MainNavigator
import ru.codavari.rickandmortyapp.usecase.GetAllCharacters
import ru.codavari.rickandmortyapp.base.BaseViewModel
import javax.inject.Inject
import ru.codavari.rickandmortyapp.data.Character

class CharactersListViewModel @Inject constructor(
    private val getAllCharacters: GetAllCharacters
) : BaseViewModel<MainNavigator>() {

    val characters = MutableLiveData<List<Character>>()

    init {
        getCharactersList()
    }

    private fun getCharactersList() {
        launch(io) {
            characters.postValue(getAllCharacters() ?: listOf())
        }
    }

}