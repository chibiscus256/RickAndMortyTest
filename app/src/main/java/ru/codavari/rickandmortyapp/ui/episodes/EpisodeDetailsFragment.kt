package ru.codavari.rickandmortyapp.ui.episodes

import ru.codavari.rickandmortyapp.R
import ru.codavari.rickandmortyapp.base.BaseFragment
import ru.codavari.rickandmortyapp.databinding.FragmentCharacterDetailsBinding
import ru.codavari.rickandmortyapp.ui.MainNavigator
import ru.codavari.rickandmortyapp.ui.characters.CharacterDetailsViewModel

class EpisodeDetailsFragment : BaseFragment<
    FragmentCharacterDetailsBinding, MainNavigator, CharacterDetailsViewModel>(
    CharacterDetailsViewModel::class.java,
    R.layout.fragment_character_details,
    ::MainNavigator,
    isViewModelStoreOwner = true
)

