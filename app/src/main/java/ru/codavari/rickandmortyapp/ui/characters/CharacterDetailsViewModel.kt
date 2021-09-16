package ru.codavari.rickandmortyapp.ui.characters

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineExceptionHandler
import ru.codavari.rickandmortyapp.base.BaseViewModel
import ru.codavari.rickandmortyapp.data.Episode
import ru.codavari.rickandmortyapp.usecase.GetCharacter
import ru.codavari.rickandmortyapp.usecase.GetEpisodes
import ru.codavari.rickandmortyapp.data.Character
import ru.codavari.rickandmortyapp.ui.MainNavigator
import javax.inject.Inject

class CharacterDetailsViewModel @Inject constructor(
    private val getCharacter: GetCharacter,
    private val getEpisodes: GetEpisodes,
) : BaseViewModel<MainNavigator>() {

    private val _episodes = MutableLiveData<List<Episode>>()
    val episodes: LiveData<List<Episode>> = _episodes

    init {
    }

}