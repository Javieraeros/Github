package es.fjruiz.github.view.fragment


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import es.fjruiz.github.R
import es.fjruiz.github.base.BaseFragment
import es.fjruiz.github.di.GoogleViewModelFactory
import es.fjruiz.github.viewmodel.UserViewModel
import es.fjruiz.github.vo.Status
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class OrganizationFragment : BaseFragment() {

    //region Static
    companion object {
        val TAG = OrganizationFragment::class.java.simpleName

        fun newInstance(): OrganizationFragment {
            val organizationFragment = OrganizationFragment()
            return organizationFragment
        }
    }
    //endregion

    //region Inject

    @Inject
    lateinit var viewModelFactory: GoogleViewModelFactory<UserViewModel>

    private val viewModel: UserViewModel by lazy { viewModelFactory.get() }
    //endregion

    //region Bind

    //endregion

    //region Fields

    //endregion

    //region Constructors & Initialization
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return getFragmentView(inflater, container)
    }
    //endregion

    //region Methods for/from SuperClass/Interfaces
    override fun getFragmentView(inflater: LayoutInflater, container: ViewGroup?): View? {
        return inflater.inflate(R.layout.fragment_organization, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.loadUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> Log.i(TAG, "Number of users: ${it.data?.size}")
                Status.ERROR -> Log.i(TAG, "Error: ")
                Status.LOADING -> Log.i(TAG, "Loading: ")
            }
        })
    }
    //endregion

    //region Methods

    //endregion

    //region Private methods

    //endregion

    //region Inner and Anonymous Classes

    //endregion

    //region Getter & Setter

    //endregion


}
