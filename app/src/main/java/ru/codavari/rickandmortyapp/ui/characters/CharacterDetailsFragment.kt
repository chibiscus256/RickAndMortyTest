package ru.codavari.rickandmortyapp.ui.characters

import androidx.navigation.fragment.navArgs
import ru.codavari.rickandmortyapp.R
import ru.codavari.rickandmortyapp.base.BaseFragment
import ru.codavari.rickandmortyapp.databinding.FragmentCharacterDetailsBinding
import ru.codavari.rickandmortyapp.ui.MainNavigator

class CharacterDetailsFragment : BaseFragment<
    FragmentCharacterDetailsBinding, MainNavigator, CharacterDetailsViewModel>(
    CharacterDetailsViewModel::class.java,
    R.layout.fragment_character_details,
    ::MainNavigator,
    isViewModelStoreOwner = true
) {
/*
    private val args: CharacterDetailsFragmentArgs by navArgs()*/
}