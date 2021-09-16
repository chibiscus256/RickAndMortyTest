package ru.codavari.rickandmortyapp.base

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.*
import ru.codavari.rickandmortyapp.BR
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import dagger.android.support.AndroidSupportInjection
import ru.codavari.rickandmortyapp.R
import ru.codavari.rickandmortyapp.activity.AppActivity
import ru.codavari.rickandmortyapp.di.ViewModelFactory
import ru.gazpromneft.tenders.base.Navigator
import javax.inject.Inject
import timber.log.Timber

abstract class BaseFragment<DB : ViewDataBinding, N : Navigator, VM : BaseViewModel<N>>(
    private val viewModelClass: Class<VM>,
    @LayoutRes private val layoutRes: Int,
    private val navigatorFactory: (NavController) -> N,
    private val isViewModelStoreOwner: Boolean = false,
    private val hasDefaultStatusBar: Boolean = true,
) : Fragment(), Base<N> {

    private val base = BaseImpl(
        navigatorFactory = { navigatorFactory(navController()) },
        requireContext = { requireContext() }
    )

    lateinit var binding: DB

    lateinit var viewModel: VM

    protected var startStatusBarColor: Int? = null
    protected var startSystemUiVisibility: Int? = null

    override val navigator: N get() = base.navigator

    fun navController(): NavController = (requireActivity() as AppActivity).findNavController()

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(
            if (isViewModelStoreOwner) this else requireActivity(),
            viewModelFactory
        ).get(viewModelClass)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        startStatusBarColor = requireActivity().window.statusBarColor
        startSystemUiVisibility = requireActivity().window.decorView.systemUiVisibility
        if (hasDefaultStatusBar)
            setDefaultStatusBar()

        binding.apply {
            setVariable(BR.viewModel, viewModel)
            lifecycleOwner = viewLifecycleOwner
            executePendingBindings()
        }
        Timber.d("subscribe on effect, class: ${javaClass}")
        viewModel.subscribeOnEffect { handleEffect(it) }
        onBind()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, layoutRes, container, false
        )
        return binding.root
    }

/*    override fun onStart() {
        binding.root.findViewById<MaterialToolbar>(R.id.topAppBar)?.let {
            it.setNavigationOnClickListener { onBackPressed() }
        }
        super.onStart()
    }*/

    open fun onBind() {}

    open fun onBackPressed() {
        navigator.back()
    }

    override fun handleEffect(effect: UIEffect) {
        Timber.d("effect: ${effect}, class: ${javaClass}")
        base.handleEffect(effect)
    }

    @SuppressLint("WrongConstant")
    protected fun setStatusBarColor(colorInt: Int, lightIcons: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val sysUiVisibility = requireActivity()
                .window
                .decorView
                .systemUiVisibility.let {
                    if (lightIcons) it xor View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                    else it or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                }

            setStatusBarColor(colorInt, sysUiVisibility)
        }
    }

    protected fun setStatusBarColor(colorInt: Int, systemUiVisibility: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requireActivity().window.apply {
                statusBarColor = colorInt
                addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                decorView.systemUiVisibility = systemUiVisibility
            }
        }
    }

    protected fun setDefaultStatusBar() {
        setStatusBarColor(
            ContextCompat.getColor(requireContext(), R.color.Main_Surface),
            false
        )
    }

    override fun onDestroy() {
        startStatusBarColor?.let { color ->
            startSystemUiVisibility?.let { visibility ->
                setStatusBarColor(color, visibility)
            }
        }

        super.onDestroy()
    }
}