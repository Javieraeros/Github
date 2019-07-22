package es.fjruiz.github.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.android.support.AndroidSupportInjection
import es.fjruiz.github.di.GoogleViewModelFactory

abstract class BaseFragment : Fragment() {

    //region Static
    companion object {
        val TAG = BaseFragment::class.java.simpleName
    }
    //endregion

    //region Inject

    //endregion

    //region Bind

    //endregion

    //region Fields

    //endregion

    //region Constructors & Initialization
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val arguments = arguments
        if (arguments != null) {
            loadArguments(arguments)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return getFragmentView(inflater,container)
    }
    //endregion

    //region Methods for/from SuperClass/Interfaces
    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
    //endregion

    //region Methods
    protected abstract fun getFragmentView(inflater: LayoutInflater, container: ViewGroup?): View?


    protected open fun toast(message: String){
        Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
    }

    protected open fun loadArguments(bundle: Bundle) {}
    //endregion

    //region Private methods

    //endregion

    //region Inner and Anonymous Classes

    inline fun <reified T : ViewModel> GoogleViewModelFactory<T>.get(): T =
        androidx.lifecycle.ViewModelProviders.of(this@BaseFragment, this)[T::class.java]
    //endregion

}