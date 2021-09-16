package ru.codavari.rickandmortyapp.ui.locations

import ru.codavari.rickandmortyapp.R
import ru.codavari.rickandmortyapp.base.BaseFragment
import ru.codavari.rickandmortyapp.databinding.FragmentCharacterDetailsBinding
import ru.codavari.rickandmortyapp.ui.MainNavigator
import ru.codavari.rickandmortyapp.ui.characters.CharacterDetailsViewModel


class LocationDetailsFragment : BaseFragment<
    FragmentCharacterDetailsBinding, MainNavigator, CharacterDetailsViewModel>(
    CharacterDetailsViewModel::class.java,
    R.layout.fragment_character_details,
    ::MainNavigator,
    isViewModelStoreOwner = true
) {

}