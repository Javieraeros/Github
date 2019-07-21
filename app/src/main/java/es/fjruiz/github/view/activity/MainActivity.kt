package es.fjruiz.github.view.activity

import android.os.Bundle
import es.fjruiz.github.R
import es.fjruiz.github.base.BaseActivity
import es.fjruiz.github.view.fragment.OrganizationFragment



class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val organizationFragment = OrganizationFragment.newInstance()
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .add(R.id.fragment_container, organizationFragment)
            .commit()
    }
}
