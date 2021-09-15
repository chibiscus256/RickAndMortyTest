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
    @Inject
    lateinit var factory: CharactersListViewModel.Factory

    private val charactersAdapter by lazy { CharactersPagedListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recCharacters by lazy { view.findViewById<RecyclerView>(R.id.rec_characters) }
        val loadingCharacters by lazy { view.findViewById<LoadingView>(R.id.loading_characters) }
        val emptyCharacters by lazy { view.findViewById<EmptyView>(R.id.empty_characters) }

        recCharacters.adapter = charactersAdapter

        viewModel.characters.observe(this, Observer {
            charactersAdapter.submitList(it)
        })

        viewModel.getCharactersState.observe(this, Observer {
            recCharacters.visibility = if (it == UiState.Complete) View.VISIBLE else View.GONE
            loadingCharacters.visibility = if (it == UiState.Loading) View.VISIBLE else View.GONE
            emptyCharacters.visibility =
                if (it is UiState.Error || it == UiState.Empty) View.VISIBLE else View.GONE
        })
    }
}