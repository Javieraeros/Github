package es.fjruiz.github.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import es.fjruiz.domain.bo.User
import es.fjruiz.domain.bo.UserDetail
import es.fjruiz.github.R
import es.fjruiz.github.base.BaseFragment
import es.fjruiz.github.di.GoogleViewModelFactory
import es.fjruiz.github.view.adapter.RepositoryAdapter
import es.fjruiz.github.viewmodel.UserDetailViewModel
import es.fjruiz.github.vo.Status
import kotlinx.android.synthetic.main.user_detail_fragment.*
import javax.inject.Inject

class UserDetailFragment : BaseFragment() {

    //region Static

    companion object {
        val TAG = UserDetailFragment::class.java.simpleName
        private const val ID = "id"
        private const val NAME = "name"
        private const val NICKNAME = "nickname"
        private const val IMAGE = "image"

        fun newInstance(user: User): UserDetailFragment {
            val fragment = UserDetailFragment()
            val bundle = Bundle()
            // TODO: 22/07/19 Improve this
            bundle.putLong(ID, user.id)
            bundle.putString(NAME, user.name)
            bundle.putString(NICKNAME, user.nickName)
            bundle.putString(IMAGE, user.image)
            fragment.arguments = bundle
            return fragment
        }
    }
    //endregion

    //region Inject
    @Inject
    lateinit var viewModelFactory: GoogleViewModelFactory<UserDetailViewModel>
    //endregion

    //region Fields
    private val viewModel: UserDetailViewModel by lazy { viewModelFactory.get() }
    private lateinit var user: User
    private val repositoryAdapter: RepositoryAdapter = RepositoryAdapter()

    //endregion

    //region Constructors & Initialization
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return getFragmentView(inflater, container)
    }
    //endregion

    //region Methods for/from SuperClass/Interfaces
    override fun loadArguments(bundle: Bundle) {
        super.loadArguments(bundle)
        val id = bundle.getLong(ID)
        val name = bundle.getString(NAME) ?: ""
        val nickName = bundle.getString(NICKNAME) ?: ""
        val image = bundle.getString(IMAGE) ?: ""
        this.user = User(id, nickName, name, image)
    }

    override fun getFragmentView(inflater: LayoutInflater, container: ViewGroup?): View? {
        return inflater.inflate(R.layout.user_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewUserDetail.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = repositoryAdapter
        }
        viewModel.loadUser(user).observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    Log.i(TAG, "Number of repos: ${it.data?.repos?.size}")
                    progressbarUserDetail.hide()
                    recyclerViewUserDetail.visibility = View.VISIBLE
                    header.visibility = View.VISIBLE
                    it.data?.let { user ->
                        showUser(user)
                    }
                }
                Status.ERROR -> {
                    Log.i(TAG, "Error: ")
                    recyclerViewUserDetail.visibility = View.GONE
                    header.visibility = View.GONE
                    progressbarUserDetail.hide()
                }
                Status.LOADING -> {
                    recyclerViewUserDetail.visibility = View.GONE
                    header.visibility = View.GONE
                    progressbarUserDetail.show()
                    Log.i(TAG, "Loading: ")
                }
            }
        })
    }

    //endregion

    //region Methods

    //endregion

    //region Private methods
    private fun showUser(user: UserDetail) {
        context?.let {
            Glide.with(it).load(user.image).into(imageViewUserAvatar)
        }
        textViewUserName.text = user.name
        textViewUserNickname.text = user.nickname
        repositoryAdapter.setRepos(user.repos)
    }
    //endregion

    //region Inner and Anonymous Classes

    //endregion

    //region Getter & Setter

    //endregion

}
