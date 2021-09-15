package ru.codavari.rickandmortyapp.ui.characters

import androidx.lifecycle.*
import com.kurt.example.rickandmorty.core.domain.entities.Episode
import com.kurt.example.rickandmorty.core.domain.usecases.GetCharacter
import com.kurt.example.rickandmorty.core.domain.usecases.GetEpisodes
import com.kurt.example.rickandmorty.core.presentation.UiState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

/**
 * Copyright 2019, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 08/01/2019
 */
class CharacterDetailsViewModel(
    private val characterId: Int,
    private val getCharacter: GetCharacter,
    private val getEpisodes: GetEpisodes
) : ViewModel() {
    class Factory(
        private val characterId: Int,
        private val getCharacter: GetCharacter,
        private val getEpisodes: GetEpisodes
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CharacterDetailsViewModel::class.java)) {
                return CharacterDetailsViewModel(characterId, getCharacter, getEpisodes) as T
            }
            throw IllegalArgumentException("ViewModel not found.")
        }
    }

    private val _character = MutableLiveData<Character>()
    val character: LiveData<Character> = _character

    private val _episodes = MutableLiveData<List<Episode>>()
    val episodes: LiveData<List<Episode>> = _episodes

    private val _getCharacterState = MutableLiveData<UiState>()
    val getCharacterState: LiveData<UiState> = _getCharacterState

    private val _getEpisodesState = MutableLiveData<UiState>()
    val getEpisodesState: LiveData<UiState> = _getEpisodesState

    init {
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            _getCharacterState.postValue(UiState.Error(throwable))
        }) {
            _getCharacterState.postValue(UiState.Loading)
            val character = getCharacter(characterId)
            _character.postValue(character)
            _getCharacterState.postValue(UiState.Complete)

            launch(CoroutineExceptionHandler { _, throwable ->
                _getEpisodesState.postValue(UiState.Error(throwable))
            }) {
                _getEpisodesState.postValue(UiState.Loading)

                val episodeIds = character.episodes
                    .map { it.split("/").last().toInt() }

                val episodes = getEpisodes(episodeIds)

                _episodes.postValue(episodes)
                _getEpisodesState.postValue(UiState.Complete)
            }
        }
    }
}