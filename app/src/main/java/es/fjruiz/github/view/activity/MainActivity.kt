package es.fjruiz.github.view.activity

import android.os.Bundle
import es.fjruiz.domain.bo.User
import es.fjruiz.github.R
import es.fjruiz.github.base.BaseActivity
import es.fjruiz.github.view.fragment.OrganizationFragment
import es.fjruiz.github.view.fragment.UserDetailFragment


/**
 * To simplify the project, only use one activity
 *
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Octokit"
        val organizationFragment = OrganizationFragment.newInstance()
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .add(R.id.fragment_container, organizationFragment)
            .commit()
    }

    fun goToUserDetail(user: User) {
        // TODO: 22/07/19
        val userFragment = UserDetailFragment.newInstance(user)
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .add(R.id.fragment_container, userFragment)
            .addToBackStack(UserDetailFragment.TAG)
            .commit()
    }
}
