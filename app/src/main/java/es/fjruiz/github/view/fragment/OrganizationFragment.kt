package es.fjruiz.github.view.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import es.fjruiz.domain.bo.User
import es.fjruiz.github.R
import es.fjruiz.github.base.BaseFragment
import es.fjruiz.github.di.GoogleViewModelFactory
import es.fjruiz.github.view.adapter.OrganizationAdapter
import es.fjruiz.github.viewmodel.UserViewModel
import es.fjruiz.github.vo.Status
import kotlinx.android.synthetic.main.fragment_organization.*
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

    private lateinit var organizationAdapter: OrganizationAdapter
    //endregion

    //region Constructors & Initialization
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        organizationAdapter = OrganizationAdapter(object : OrganizationAdapter.OrganizationListener {
            override fun onUserClick(user: User) {
                // TODO: 22/07/19
                toast("En desarrollo")
            }
        })
        return getFragmentView(inflater, container)
    }
    //endregion

    //region Methods for/from SuperClass/Interfaces
    override fun getFragmentView(inflater: LayoutInflater, container: ViewGroup?): View? {
        return inflater.inflate(R.layout.fragment_organization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = organizationAdapter
        }
        viewModel.loadUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    Log.i(TAG, "Number of users: ${it.data?.size}")
                    progressbar.hide()
                    recyclerView.visibility = View.VISIBLE
                    it.data?.let { users ->
                        showUsers(users)
                    }
                }
                Status.ERROR -> {
                    Log.i(TAG, "Error: ")
                    recyclerView.visibility = View.GONE
                    progressbar.hide()
                }
                Status.LOADING -> {
                    recyclerView.visibility = View.GONE
                    progressbar.show()
                    Log.i(TAG, "Loading: ")
                }
            }
        })
    }
    //endregion

    //region Methods
    fun showUsers(users: List<User>) {
        organizationAdapter.setUsers(users)
    }
    //endregion

    //region Private methods

    //endregion

    //region Inner and Anonymous Classes

    //endregion

    //region Getter & Setter

    //endregion


}
