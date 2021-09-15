package ru.codavari.rickandmortyapp.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.android.support.AndroidSupportInjection
import ru.codavari.rickandmortyapp.activity.AppActivity
import ru.codavari.rickandmortyapp.di.ViewModelFactory
import ru.gazpromneft.tenders.base.BaseViewModel
import ru.gazpromneft.tenders.base.Navigator
import ru.gazpromneft.tenders.base.UIEffect
import ru.gazpromneft.tenders.common.extensions.launchCollect
import ru.gazpromneft.tenders.di.ViewModelFactory
import javax.inject.Inject

open class BaseBottomSheetDialogFragment<DB : ViewDataBinding, N : Navigator, VM : BaseViewModel<N>>(
    private val viewModelClass: Class<VM>,
    private val layoutRes: Int,
    private val navigatorFactory: (NavController) -> N,
) : BottomSheetDialogFragment(), Base<N> {

    private val base = BaseImpl(
        navigatorFactory = { navigatorFactory(navController()) },
        requireContext = { requireContext() }
    )

    override val navigator: N get() = base.navigator

    lateinit var binding: DB

    lateinit var viewModel: VM

    fun navController() = ( requireActivity() as AppActivity).findNavController()

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(viewModelClass)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            setVariable(BR.viewModel, viewModel)
            lifecycleOwner = viewLifecycleOwner
            executePendingBindings()
        }
        viewModel.effect.launchCollect(lifecycleScope) { handleEffect(it) }
        onBind()
    }

    protected open fun onBind() {}

    override fun handleEffect(effect: UIEffect) = base.handleEffect(effect)
}