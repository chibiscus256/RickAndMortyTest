package ru.codavari.rickandmortyapp.ui.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import ru.codavari.rickandmortyapp.R
import ru.codavari.rickandmortyapp.base.BaseFragment
import ru.codavari.rickandmortyapp.databinding.FragmentCharactersListBinding
import ru.codavari.rickandmortyapp.ui.MainNavigator
import javax.inject.Inject

class CharactersListFragment : BaseFragment<
    FragmentCharactersListBinding, MainNavigator, CharactersListViewModel>(
    CharactersListViewModel::class.java,
    R.layout.fragment_characters_list,
    ::MainNavigator,
    isViewModelStoreOwner = true
) {

}