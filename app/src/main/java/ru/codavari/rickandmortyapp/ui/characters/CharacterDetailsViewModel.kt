package ru.codavari.rickandmortyapp.ui.characters

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import ru.codavari.rickandmortyapp.data.Episode
import ru.codavari.rickandmortyapp.usecase.GetCharacter
import ru.codavari.rickandmortyapp.usecase.GetEpisodes
import ru.codavari.rickandmortyapp.data.Character

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