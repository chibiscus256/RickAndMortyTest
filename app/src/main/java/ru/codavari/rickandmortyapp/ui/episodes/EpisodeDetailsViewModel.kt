package ru.codavari.rickandmortyapp.ui.episodes

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import ru.codavari.rickandmortyapp.base.BaseViewModel
import ru.codavari.rickandmortyapp.ui.MainNavigator
import ru.codavari.rickandmortyapp.usecase.GetAllCharacters
import javax.inject.Inject

class EpisodeDetailsViewModel @Inject constructor(
) : BaseViewModel<MainNavigator>() {

}