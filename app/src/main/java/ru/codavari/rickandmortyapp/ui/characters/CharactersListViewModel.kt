package ru.codavari.rickandmortyapp.ui.characters

import androidx.lifecycle.*
import ru.codavari.rickandmortyapp.ui.MainNavigator
import ru.codavari.rickandmortyapp.usecase.GetAllCharacters
import ru.gazpromneft.tenders.base.BaseViewModel
import javax.inject.Inject

class CharactersListViewModel @Inject constructor(
    private val getAllCharacters: GetAllCharacters
) : BaseViewModel<MainNavigator>() {

    private val charactersDataSourceFactory =
        CharactersDataSource.Factory(getAllCharacters, viewModelScope)

    val characters: LiveData<PagedList<Character>> =
        LivePagedListBuilder(charactersDataSourceFactory, 20).build()

    val getCharactersState: LiveData<UiState> =
        Transformations.switchMap(charactersDataSourceFactory.sourceLiveData) {
            it.getCharactersState
        }
}